package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.Brita
import br.com.rafaelhfernandes.core.framework.model.BaseResponse

interface PriceRemoteResource {
    suspend fun getDollarPriceToday(): BaseResponse<Brita>
}