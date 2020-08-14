package pro.jsandoval.mvisample.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonsResponse(
    @SerializedName("results") @Expose val pokemons: List<PokemonResponse> = arrayListOf()
)

data class PokemonResponse(
    @SerializedName("name") @Expose val name: String,
    @SerializedName("url") @Expose val url: String
)