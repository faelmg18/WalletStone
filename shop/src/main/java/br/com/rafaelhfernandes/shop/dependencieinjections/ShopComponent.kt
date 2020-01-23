package br.com.rafaelhfernandes.shop.dependencieinjections

import br.com.rafaelhfernandes.core.dependenciesinjections.CoreComponent
import br.com.rafaelhfernandes.shop.screens.fragments.ShopHomeFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class], modules = [ShopModule::class])
interface ShopComponent {
    fun inject(shopHomeFragment: ShopHomeFragment)
}