package ru.compose.gamesexplorer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.compose.gamesexplorer.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

//    private val _data: MutableState<MainAppState> = mutableStateOf(MainAppState.Loading)
//    val data = _data

    val pager = repository.pager.cachedIn(viewModelScope)

    init {
//        viewModelScope.launch {
//            try {
//                _data.value = MainAppState.Success(repository.getDefaultGames(1))
//            } catch (e: Exception) {
//                _data.value = MainAppState.Error(e)
//            }
//        }
    }
}
