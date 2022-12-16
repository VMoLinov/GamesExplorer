package ru.compose.gamesexplorer.repository

import ru.compose.gamesexplorer.model.dto.GameDto
import ru.compose.gamesexplorer.network.NetworkDao
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val network: NetworkDao) : MainRepository {

    override suspend fun getDefaultGames(): List<GameDto> = network.games().results
}
