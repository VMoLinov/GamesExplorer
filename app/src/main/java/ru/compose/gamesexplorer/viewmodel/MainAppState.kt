package ru.compose.gamesexplorer.viewmodel

import ru.compose.gamesexplorer.model.local.GameModel

sealed class MainAppState {
    class Success(val data: List<GameModel>) : MainAppState()
    class Error(val error: Exception) : MainAppState()
    object Loading : MainAppState()
}
