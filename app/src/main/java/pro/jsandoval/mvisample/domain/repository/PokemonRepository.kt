package pro.jsandoval.mvisample.domain.repository

import kotlinx.coroutines.flow.Flow
import pro.jsandoval.mvisample.domain.model.Pokemon
import pro.jsandoval.mvisample.util.DataState

interface PokemonRepository {
    fun getPokemons(): Flow<DataState<List<Pokemon>>>
}