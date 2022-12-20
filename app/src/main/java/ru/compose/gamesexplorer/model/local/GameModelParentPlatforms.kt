package ru.compose.gamesexplorer.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModelParentPlatforms(
    val id: Long,
    val name: String,
    val slug: String,
    val platforms: List<GameModelPlatforms>
) : Parcelable
