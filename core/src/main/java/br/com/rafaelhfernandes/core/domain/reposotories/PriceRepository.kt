package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.framework.model.BaseResponse

interface PriceRepository {
    suspend fun getDollarPriceToday(): BaseResponse<Price>
    suspend fun retrieveDollarPrice(): Price
    suspend fun save(price: Price)
}