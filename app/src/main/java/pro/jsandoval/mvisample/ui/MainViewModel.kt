package pro.jsandoval.mvisample.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import pro.jsandoval.mvisample.domain.model.Pokemon
import pro.jsandoval.mvisample.domain.usecase.GetPokemonsUseCase
import pro.jsandoval.mvisample.util.DataType

@ExperimentalCoroutinesApi
class MainViewModel @ViewModelInject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    val actionChannel = Channel<PokemonAction>(Channel.UNLIMITED)

    private val _pokemonsUiState = MutableStateFlow<PokemonUiState>(PokemonUiState.Idle)
    val pokemonsUiState: StateFlow<PokemonUiState>
        get() = _pokemonsUiState

    init {
        viewModelScope.launch { handleActions() }
    }

    private suspend fun handleActions() {
        actionChannel.consumeAsFlow().collect { action ->
            when (action) {
                PokemonAction.LoadPokemons -> loadPokemons()
            }
        }
    }

    private suspend fun loadPokemons() {
        getPokemonsUseCase.invoke().collect { dataState ->
            _pokemonsUiState.value = PokemonUiState.Loading(dataState.loading)
            when (dataState.type) {
                DataType.Success -> _pokemonsUiState.value = PokemonUiState.Success(dataState.data)
                DataType.Error -> _pokemonsUiState.value = PokemonUiState.Error(dataState.message)
            }
        }
    }

}

sealed class PokemonAction {
    object LoadPokemons : PokemonAction()
}

sealed class PokemonUiState {
    object Idle : PokemonUiState()
    data class Loading(val isLoading: Boolean) : PokemonUiState()
    data class Success(val data: List<Pokemon>?) : PokemonUiState()
    data class Error(val errorMessage: String?) : PokemonUiState()
}