package ru.compose.gamesexplorer.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.compose.gamesexplorer.model.dto.GameDto
import ru.compose.gamesexplorer.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val _data: MutableState<List<GameDto>> = mutableStateOf(listOf())
    val data = _data

    init {
        viewModelScope.launch {
            _data.value = repository.getDefaultGames()
        }
    }
}
