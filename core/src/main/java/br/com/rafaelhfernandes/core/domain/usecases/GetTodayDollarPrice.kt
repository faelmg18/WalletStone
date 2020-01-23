package br.com.rafaelhfernandes.core.domain.usecases

import br.com.rafaelhfernandes.core.data.price.BritaDataSource
import javax.inject.Inject

class GetTodayDollarPrice @Inject constructor(
    private val britaDataSource: BritaDataSource
) {
    suspend operator fun invoke() = britaDataSource.retrieveBrita()
}