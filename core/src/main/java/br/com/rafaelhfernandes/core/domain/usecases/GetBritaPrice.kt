package br.com.rafaelhfernandes.core.domain.usecases

import br.com.rafaelhfernandes.core.domain.reposotories.BritaRepository
import javax.inject.Inject

class GetBritaPrice @Inject constructor(
    private val britaRepository: BritaRepository
) {
    suspend operator fun invoke() = britaRepository.getDollarPriceToday()
}