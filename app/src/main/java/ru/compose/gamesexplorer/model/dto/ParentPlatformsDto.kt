package ru.compose.gamesexplorer.model.dto

import com.google.gson.annotations.SerializedName

data class ParentPlatformsDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("platforms") val platforms: List<PlatformsDto>
)
