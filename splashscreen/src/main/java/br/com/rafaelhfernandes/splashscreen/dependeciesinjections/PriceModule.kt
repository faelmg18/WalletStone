package br.com.rafaelhfernandes.splashscreen.dependeciesinjections

import br.com.rafaelhfernandes.core.domain.usecases.GetDollarPrice
import br.com.rafaelhfernandes.core.presentation.price.PriceViewModel
import dagger.Module
import dagger.Provides

@Module
class PriceModule {

    @Provides
    fun providePriceViewModelFactory(
        getDollarPrice: GetDollarPrice
    ) = PriceViewModel.Factory(getDollarPrice)

}
