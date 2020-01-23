package br.com.rafaelhfernandes.transaction.dependeciesinjections

import br.com.rafaelhfernandes.core.presentation.transactions.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class TransasionModule {
    @Provides
    fun provideHomeViewModelFactory(
    ) = HomeViewModel.Factory()
}