package br.com.rafaelhfernandes.core.dependenciesinjections

import br.com.rafaelhfernandes.core.domain.reposotories.PriceRepository
import dagger.Component

@Component(modules = [PriceModule::class])
interface CoreComponent {
    fun providePriceRepository(): PriceRepository
}