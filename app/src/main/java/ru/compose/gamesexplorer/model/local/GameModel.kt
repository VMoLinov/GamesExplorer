package ru.compose.gamesexplorer.model.local

import android.net.Uri
import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameModel(
    val id: Long,
    val title: String,
    val image: String?,
    val released: String,
    val added: Long,
    val rating: Float,
    val parentPlatforms: List<GameModelParentPlatforms>
) : Parcelable {

    override fun toString(): String {
        return Uri.encode(Gson().toJson(this))
    }
}
