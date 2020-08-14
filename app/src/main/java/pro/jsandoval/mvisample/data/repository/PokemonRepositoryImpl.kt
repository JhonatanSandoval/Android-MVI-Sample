package pro.jsandoval.mvisample.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.jsandoval.mvisample.data.api.Api
import pro.jsandoval.mvisample.data.api.response.PokemonsResponse
import pro.jsandoval.mvisample.data.mapper.PokemonMapper
import pro.jsandoval.mvisample.domain.model.Pokemon
import pro.jsandoval.mvisample.domain.repository.PokemonRepository
import pro.jsandoval.mvisample.util.ApiResponseHandler
import pro.jsandoval.mvisample.util.DataState
import pro.jsandoval.mvisample.util.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val api: Api,
    private val pokemonMapper: PokemonMapper
) : PokemonRepository {

    /**
     * Regions:
     * Kanto -> from 0 to 150
     * Johto -> from 151 to 250
     * Hoeen -> from 251 to 385
     * Sinnoh -> from 386 to 492
     * etc. etc.
     */

    override fun getPokemons(): Flow<DataState<List<Pokemon>>> = flow {
        emit(DataState.loading(true))

        val apiCall = safeApiCall { api.getPokemons(0, 150) }
        emit(
            object : ApiResponseHandler<List<Pokemon>, PokemonsResponse>(response = apiCall) {
                override suspend fun handleSuccess(resultObj: PokemonsResponse): DataState<List<Pokemon>> {
                    return DataState.data(
                        message = null,
                        data = resultObj.pokemons.map { pokemonMapper.invoke(it) }
                    )
                }
            }.getResult()
        )

    }
}