package pro.jsandoval.mvisample.data.api

import pro.jsandoval.mvisample.data.api.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v2/pokemon")
    suspend fun getPokemons(@Query("offset") offset: Int, @Query("limit") limit: Int): PokemonsResponse

}