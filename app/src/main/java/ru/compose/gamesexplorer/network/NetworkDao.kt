package ru.compose.gamesexplorer.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.compose.gamesexplorer.model.dto.GamesResponseDto
import ru.compose.gamesexplorer.model.dto.PlatformsResponseDto

interface NetworkDao {

    @GET("/api/games")
    suspend fun games(@Query("page") page: Int): GamesResponseDto

    @GET("/api/platforms/lists/parents")
    suspend fun parentPlatforms(): PlatformsResponseDto
}
