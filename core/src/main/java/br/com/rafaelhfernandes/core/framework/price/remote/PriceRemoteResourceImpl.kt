package br.com.rafaelhfernandes.core.framework.price.remote

import br.com.rafaelhfernandes.core.data.price.PriceRemoteResource
import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.framework.BaseRemoteSource
import br.com.rafaelhfernandes.core.framework.model.BaseResponse
import br.com.rafaelhfernandes.core.framework.price.PriceApi
import javax.inject.Inject

class PriceRemoteResourceImpl @Inject constructor(): BaseRemoteSource<PriceApi>(PriceApi::class.java),
    PriceRemoteResource {
    override suspend fun getDollarPriceToday(): BaseResponse<Price> {
        return api.getDollarPriceToday()
    }
}