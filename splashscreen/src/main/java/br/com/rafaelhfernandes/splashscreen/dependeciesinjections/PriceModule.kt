package br.com.rafaelhfernandes.splashscreen.dependeciesinjections

import br.com.rafaelhfernandes.core.domain.usecases.GetBritaPrice
import br.com.rafaelhfernandes.core.presentation.price.SplashViewModel
import dagger.Module
import dagger.Provides

@Module
class PriceModule {

    @Provides
    fun providePriceViewModelFactory(
        getBritaPrice: GetBritaPrice
    ) = SplashViewModel.Factory(getBritaPrice)

}
