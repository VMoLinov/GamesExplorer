package ru.compose.gamesexplorer.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.compose.gamesexplorer.model.local.GameModel
import javax.inject.Inject

class GamesSource @Inject constructor(
    private val gamesRepository: MainRepository
) : PagingSource<Int, GameModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameModel> {
        return try {
            val nextPage = params.key ?: 1
            val gamesResponse = gamesRepository.getDefaultGames(nextPage)
            LoadResult.Page(
                data = gamesResponse,
                prevKey = null,
                nextKey = nextPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GameModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
