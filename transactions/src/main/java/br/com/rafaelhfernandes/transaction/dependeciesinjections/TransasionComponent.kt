package br.com.rafaelhfernandes.transaction.dependeciesinjections

import br.com.rafaelhfernandes.core.dependenciesinjections.CoreComponent
import br.com.rafaelhfernandes.transaction.screens.TransactionsHomeFragment
import dagger.Component


@Component(dependencies = [CoreComponent::class], modules = [TransasionModule::class])
interface TransasionComponent {

    fun inject(transactionsHomeFragment: TransactionsHomeFragment)

}