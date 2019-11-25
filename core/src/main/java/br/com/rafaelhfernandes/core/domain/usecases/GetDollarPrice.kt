package br.com.rafaelhfernandes.core.domain.usecases

import br.com.rafaelhfernandes.core.domain.reposotories.PriceRepository
import javax.inject.Inject

class GetDollarPrice @Inject constructor(
    private val priceRepository: PriceRepository
) {
    suspend operator fun invoke() = priceRepository.getDollarPriceToday()
}