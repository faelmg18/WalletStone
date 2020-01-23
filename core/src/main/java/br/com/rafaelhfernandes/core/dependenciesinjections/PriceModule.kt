package br.com.rafaelhfernandes.core.dependenciesinjections

import br.com.rafaelhfernandes.core.domain.reposotories.PriceRemoteResource
import br.com.rafaelhfernandes.core.data.price.BritaRepositoryImpl
import br.com.rafaelhfernandes.core.domain.reposotories.BritaRepository
import br.com.rafaelhfernandes.core.framework.price.remote.PriceRemoteResourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PriceModule {
    @Binds
    abstract fun providePriceRepository(
        priceRepositoryImpl: BritaRepositoryImpl
    ): BritaRepository

    @Binds
    abstract fun provideRemoteSource(priceRemoteSourceImpl: PriceRemoteResourceImpl): PriceRemoteResource

}