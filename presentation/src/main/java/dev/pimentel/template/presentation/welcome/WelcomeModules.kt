package dev.pimentel.template.presentation.welcome

import dev.pimentel.template.presentation.welcome.data.WelcomeState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
object WelcomeViewModelModule {

    @Provides
    @ViewModelScoped
    @WelcomeStateQualifier
    fun provideInitialState(): WelcomeState = WelcomeState()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class WelcomeStateQualifier
