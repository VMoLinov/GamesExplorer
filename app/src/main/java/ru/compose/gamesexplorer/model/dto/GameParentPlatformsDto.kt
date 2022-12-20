package ru.compose.gamesexplorer.model.dto

import com.google.gson.annotations.SerializedName

data class GameParentPlatformsDto(
    @SerializedName("platform") val platformDto: GameSimplePlatformDto
)
