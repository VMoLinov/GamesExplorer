package ru.compose.gamesexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.compose.gamesexplorer.navigation.AppNavHost
import ru.compose.gamesexplorer.ui.theme.GamesExplorerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamesExplorerTheme { AppNavHost() }
        }
    }
}
