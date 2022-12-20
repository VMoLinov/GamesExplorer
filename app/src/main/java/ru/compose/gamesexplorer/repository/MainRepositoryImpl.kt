package ru.compose.gamesexplorer.repository

import ru.compose.gamesexplorer.model.local.GameModel
import ru.compose.gamesexplorer.model.local.GameModelParentPlatforms
import ru.compose.gamesexplorer.network.NetworkDao
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val network: NetworkDao) : MainRepository {

    override suspend fun getDefaultGames(): List<GameModel> {
        val platformsDto = network.parentPlatforms().results
        return network.games().results.map { gameDto ->
            val platforms = mutableListOf<GameModelParentPlatforms>()
            gameDto.parentPlatforms.forEach { gameDtoPlatforms ->
                platformsDto.find { it.id == gameDtoPlatforms.platformDto.id }
                    ?.let { platforms.add(it.toModel()) }
            }
            GameModel(
                gameDto.id,
                gameDto.title,
                gameDto.image,
                gameDto.released,
                gameDto.added,
                gameDto.rating,
                platforms
            )
        }
    }
}
