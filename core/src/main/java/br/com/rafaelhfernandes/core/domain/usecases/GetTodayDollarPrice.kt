package br.com.rafaelhfernandes.core.domain.usecases

import br.com.rafaelhfernandes.core.data.price.PriceDataSource
import br.com.rafaelhfernandes.core.domain.reposotories.PriceRepository
import javax.inject.Inject

class GetTodayDollarPrice @Inject constructor(
    private val priceDataSource: PriceDataSource
) {
    suspend operator fun invoke() = priceDataSource.retrieveDollar()
}