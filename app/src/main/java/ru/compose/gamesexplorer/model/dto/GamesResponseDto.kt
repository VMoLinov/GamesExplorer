package ru.compose.gamesexplorer.model.dto

import com.google.gson.annotations.SerializedName

data class GamesResponseDto(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("previous") val previousPageUrl: String,
    @SerializedName("results") val results: List<GameDto>
)
