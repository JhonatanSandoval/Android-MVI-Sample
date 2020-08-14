package pro.jsandoval.mvisample.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier

@Module
@InstallIn(ApplicationComponent::class)
object QualifiersModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PokemonRepository

}