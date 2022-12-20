package ru.compose.gamesexplorer.model.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModelPlatforms(
    val id: Long,
    val name: String,
    val slug: String,
    val count: Int,
    val image: String,
    val img: String?,
    val yearStart: Int?,
    val yearEnd: Int?,
) : Parcelable
