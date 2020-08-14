package pro.jsandoval.mvisample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import pro.jsandoval.mvisample.data.api.Api
import pro.jsandoval.mvisample.data.mapper.PokemonMapper
import pro.jsandoval.mvisample.data.repository.PokemonRepositoryImpl
import pro.jsandoval.mvisample.domain.repository.PokemonRepository

/**
 * Can improve it with abstract class and methods
 */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @QualifiersModule.PokemonRepository
    fun providePokemonRepository(api: Api, pokemonMapper: PokemonMapper): PokemonRepository {
        return PokemonRepositoryImpl(api, pokemonMapper)
    }

}