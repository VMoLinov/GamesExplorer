package ru.compose.gamesexplorer.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import ru.compose.gamesexplorer.model.local.GameModel

class GameNav : NavType<GameModel>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): GameModel? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): GameModel {
        return Gson().fromJson(value, GameModel::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: GameModel) {
        bundle.putParcelable(key, value)
    }
}
