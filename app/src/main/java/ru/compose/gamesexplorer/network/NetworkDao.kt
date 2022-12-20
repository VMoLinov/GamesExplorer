package ru.compose.gamesexplorer.network

import retrofit2.http.GET
import ru.compose.gamesexplorer.model.dto.GamesResponseDto
import ru.compose.gamesexplorer.model.dto.PlatformsResponseDto

interface NetworkDao {

    @GET("/api/games")
    suspend fun games(): GamesResponseDto

    @GET("/api/platforms/lists/parents")
    suspend fun parentPlatforms(): PlatformsResponseDto
}
