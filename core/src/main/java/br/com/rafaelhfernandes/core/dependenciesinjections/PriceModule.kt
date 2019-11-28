package br.com.rafaelhfernandes.core.dependenciesinjections

import br.com.rafaelhfernandes.core.domain.reposotories.PriceRemoteResource
import br.com.rafaelhfernandes.core.data.price.PriceRepositoryImpl
import br.com.rafaelhfernandes.core.domain.reposotories.PriceRepository
import br.com.rafaelhfernandes.core.framework.price.remote.PriceRemoteResourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PriceModule {
    @Binds
    abstract fun providePriceRepository(
        priceRepositoryImpl: PriceRepositoryImpl
    ): PriceRepository

    @Binds
    abstract fun provideRemoteSource(priceRemoteSourceImpl: PriceRemoteResourceImpl): PriceRemoteResource

}