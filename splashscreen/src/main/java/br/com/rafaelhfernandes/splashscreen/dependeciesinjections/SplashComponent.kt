package br.com.rafaelhfernandes.splashscreen.dependeciesinjections

import br.com.rafaelhfernandes.core.dependenciesinjections.CoreComponent
import br.com.rafaelhfernandes.splashscreen.screens.fragments.SplashScreenFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class], modules = [PriceModule::class])
interface SplashComponent {
    fun inject(splashScreenFragment: SplashScreenFragment)
}