package ru.compose.gamesexplorer.ui.screens

import androidx.compose.runtime.Composable
import ru.compose.gamesexplorer.model.dto.GameDto

@Composable
fun DetailsScreen(game: GameDto) {
    GameItem(game) {

    }
}
