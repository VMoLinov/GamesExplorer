package ru.compose.gamesexplorer.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameParentPlatformsDto(
    @SerializedName("platform") val platformDto: GameSimplePlatformDto
) : Parcelable
