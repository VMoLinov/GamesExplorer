package ru.compose.gamesexplorer.repository

import ru.compose.gamesexplorer.model.dto.GameDto

interface MainRepository {

    suspend fun getDefaultGames() : List<GameDto>
}