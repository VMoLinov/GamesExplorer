package ru.compose.gamesexplorer.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.compose.gamesexplorer.BuildConfig
import ru.compose.gamesexplorer.network.NetworkDao
import ru.compose.gamesexplorer.repository.MainRepository
import ru.compose.gamesexplorer.repository.MainRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
object AppComponent {

    @Provides
    fun mainRepository(network: NetworkDao): MainRepository {
        return MainRepositoryImpl(network)
    }

    @Provides
    fun provideApi(@ApplicationContext context: Context): NetworkDao {
        val apiKey = "c14af972658d4d89b5fdbd1c6a61ccf5"
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val request = originalRequest.newBuilder().url(
                    originalRequest.url.newBuilder()
                        .addQueryParameter("key", apiKey)
                        .build()
                ).build()
                chain.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }).build()
            ).build().create(NetworkDao::class.java)
    }

    private const val BASE_URL = "https://api.rawg.io/"
}
