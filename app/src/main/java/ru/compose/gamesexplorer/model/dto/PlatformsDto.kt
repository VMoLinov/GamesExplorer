package ru.compose.gamesexplorer.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlatformsDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("games_count") val count: Int,
    @SerializedName("image_background") val image: String,
    @SerializedName("image") val img: String?,
    @SerializedName("year_start") val yearStart: Int?,
    @SerializedName("year_end") val yearEnd: Int?,
    @SerializedName("games") val games: List<GameDto>
) : Parcelable
