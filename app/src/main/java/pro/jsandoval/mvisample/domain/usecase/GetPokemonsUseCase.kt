package pro.jsandoval.mvisample.domain.usecase

import pro.jsandoval.mvisample.di.QualifiersModule
import pro.jsandoval.mvisample.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    @QualifiersModule.PokemonRepository private val pokemonRepository: PokemonRepository
) {
    operator fun invoke() = pokemonRepository.getPokemons()
}