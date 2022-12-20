package ru.compose.gamesexplorer.model.dto

import com.google.gson.annotations.SerializedName
import ru.compose.gamesexplorer.model.local.GameModelParentPlatforms

data class ParentPlatformsDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("platforms") val platforms: List<PlatformsDto>
) {

    fun toModel(): GameModelParentPlatforms {
        return GameModelParentPlatforms(
            id = id,
            name = name,
            slug = slug,
            platforms = platforms.map { it.toModel() }
        )
    }
}
