package ru.compose.gamesexplorer.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.compose.gamesexplorer.model.local.GameModel
import ru.compose.gamesexplorer.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigateToDetails: (GameModel) -> Unit
) {
    Drawer {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) { ShowData(games = viewModel.pager, onNavigateToDetails = onNavigateToDetails) }
    }
}

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer(content: @Composable (PaddingValues) -> Unit) {
    val drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            Surface(
                Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight()
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                    Divider()
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Button")
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(topBar = {
            TopAppBar(modifier = Modifier.padding(horizontal = 16.dp),
                title = { Text(modifier = Modifier.padding(horizontal = 16.dp), text = "Main") },
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { scope.launch { drawerState.open() } },
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                })
        }) { content(it) }
    }
}

@Composable
fun ShowLoading() {
    Box(contentAlignment = Alignment.BottomCenter) {
        CircularProgressIndicator()
    }
}

@Composable
fun ShowData(games: Flow<PagingData<GameModel>>, onNavigateToDetails: (GameModel) -> Unit) {
    val items = games.collectAsLazyPagingItems()
    val gridCells = 2
    LazyVerticalGrid(
        modifier = Modifier.padding(8.dp),
        columns = GridCells.Fixed(gridCells)
    ) {
        items(count = items.itemCount) { index ->
            items[index]?.let { GameItem(game = it, onCLick = onNavigateToDetails) }
        }
        when (items.loadState.append) {
            is LoadState.Loading -> {
                item(span = { GridItemSpan(gridCells) }) { ShowLoading() }
            }
            is LoadState.Error -> item {
                Toast.makeText(
                    LocalContext.current,
                    (items.loadState.append as LoadState.Error).error.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            is LoadState.NotLoading -> Unit
        }
    }
}

@Composable
fun GameItem(game: GameModel, onCLick: (GameModel) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onCLick(game) },
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            GameImage(game.image)
            PlatformsRow(game)
            GameTitle(game.title)
        }
    }
}

@Composable
private fun GameTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun PlatformsRow(game: GameModel) {
    LazyRow {
        items(items = game.parentPlatforms) {
            Text(text = it.name)
        }
    }
}

@Suppress("OPT_IN_IS_NOT_ENABLED")
@Composable
@OptIn(ExperimentalGlideComposeApi::class)
private fun GameImage(image: String?) {
    GlideImage(
        contentScale = ContentScale.Crop,
        model = image,
        contentDescription = "image",
        modifier = Modifier
            .height(200.dp)
    )
}
