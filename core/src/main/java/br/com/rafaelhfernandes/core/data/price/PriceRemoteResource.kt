package br.com.rafaelhfernandes.core.data.price

import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.framework.model.BaseResponse

interface PriceRemoteResource {
    suspend fun getDollarPriceToday(): BaseResponse<Price>
}