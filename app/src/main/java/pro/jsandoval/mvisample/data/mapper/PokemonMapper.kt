package pro.jsandoval.mvisample.data.mapper

import pro.jsandoval.mvisample.data.api.response.PokemonResponse
import pro.jsandoval.mvisample.domain.Mapper
import pro.jsandoval.mvisample.domain.model.Pokemon
import javax.inject.Inject

class PokemonMapper @Inject constructor() : Mapper<PokemonResponse, Pokemon> {

    override fun invoke(p1: PokemonResponse): Pokemon {
        return Pokemon(p1.name, p1.url)
    }

}