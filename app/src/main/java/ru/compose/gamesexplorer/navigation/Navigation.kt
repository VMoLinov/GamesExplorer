package ru.compose.gamesexplorer.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.compose.gamesexplorer.model.dto.GameDto
import ru.compose.gamesexplorer.model.dto.GameNav
import ru.compose.gamesexplorer.ui.screens.DetailsScreen
import ru.compose.gamesexplorer.ui.screens.MainScreen

@SuppressLint("NewApi")
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("main") {
            MainScreen(onNavigateToDetails = { gameDto ->
                navController.navigate("details/$gameDto")
            })
        }
        composable(
            "details/{game}",
            arguments = listOf(navArgument("game") { type = GameNav() })
        ) {
            val arg = it.arguments?.getParcelable<GameDto>("game")
            arg?.let { game -> DetailsScreen(game) }
        }
    }
}
