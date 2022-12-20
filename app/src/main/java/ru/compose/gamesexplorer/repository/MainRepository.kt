package ru.compose.gamesexplorer.repository

import ru.compose.gamesexplorer.model.local.GameModel

interface MainRepository {

    suspend fun getDefaultGames(): List<GameModel>
}