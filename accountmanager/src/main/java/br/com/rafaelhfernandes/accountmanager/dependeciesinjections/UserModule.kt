package br.com.rafaelhfernandes.accountmanager.dependeciesinjections

import br.com.rafaelhfernandes.core.presentation.accountmanager.AccountManagerViewModel
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun provideUserViewModelFactory(
    ) = AccountManagerViewModel.Factory()
}