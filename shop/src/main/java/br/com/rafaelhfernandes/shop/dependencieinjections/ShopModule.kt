package br.com.rafaelhfernandes.shop.dependencieinjections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.rafaelhfernandes.core.presentation.shop.ShopHomeViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ShopModule {
    @Provides
    fun provideShopHomeViewModelFactory(
    ) = Factory(ShopHomeViewModel::class.java)

    class Factory<C> @Inject constructor(
        val clazz: Class<C>
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return clazz.newInstance() as T
        }
    }
}