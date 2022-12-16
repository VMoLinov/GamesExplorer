package ru.compose.gamesexplorer.model.dto

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val title: String,
    @SerializedName("background_image") val image: String?,
    @SerializedName("released") val released: String,
    @SerializedName("added") val added: Long,
    @SerializedName("rating") val rating: Float,
//    @SerializedName("platforms") val platforms: List<PlatformsDto>,
//    @SerializedName("parent_platforms") val parentPlatforms: List<GameParentPlatformsDto>
) : Parcelable {

    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}

class GameNav : NavType<GameDto>(isNullableAllowed = true) {

    override fun get(bundle: Bundle, key: String): GameDto? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): GameDto {
        return Gson().fromJson(value, GameDto::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: GameDto) {
        bundle.putParcelable(key, value)
    }
}
