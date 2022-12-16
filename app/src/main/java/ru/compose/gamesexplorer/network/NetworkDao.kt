package ru.compose.gamesexplorer.network

import retrofit2.http.GET
import ru.compose.gamesexplorer.model.dto.GamesResponseDto

interface NetworkDao {

    @GET("/api/games")
    suspend fun games(): GamesResponseDto
}
