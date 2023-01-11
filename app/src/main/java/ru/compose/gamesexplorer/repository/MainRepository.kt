package ru.compose.gamesexplorer.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.compose.gamesexplorer.model.local.GameModel

interface MainRepository {

    val pager: Flow<PagingData<GameModel>>

    suspend fun getDefaultGames(page: Int): List<GameModel>
}
