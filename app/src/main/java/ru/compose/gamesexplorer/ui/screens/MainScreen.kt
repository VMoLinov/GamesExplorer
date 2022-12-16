package ru.compose.gamesexplorer.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.compose.gamesexplorer.model.dto.GameDto
import ru.compose.gamesexplorer.ui.theme.GamesExplorerTheme
import ru.compose.gamesexplorer.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigateToDetails: (GameDto) -> Unit
) {
    val data = viewModel.data.value.toList()
    GamesExplorerTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(items = data) {
                    GameItem(it, onNavigateToDetails)
                }
            }
        }
    }
}

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GameItem(game: GameDto, onCLick: (GameDto) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onCLick(game) },
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                contentScale = ContentScale.Crop,
                model = game.image,
                contentDescription = "image",
                modifier = Modifier
                    .height(200.dp)
            )
            LazyRow {
//                items(items = game.parentPlatforms) {
//                    Text(text = it.platformDto.name)
//                }
            }
            Text(text = game.title)
        }
    }
}
