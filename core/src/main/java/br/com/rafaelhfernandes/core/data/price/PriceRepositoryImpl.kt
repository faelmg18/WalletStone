package br.com.rafaelhfernandes.core.data.price

import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.domain.reposotories.PriceRepository
import br.com.rafaelhfernandes.core.framework.model.BaseResponse
import javax.inject.Inject

class PriceRepositoryImpl @Inject constructor(
    private val priceRemoteResource: PriceRemoteResource
) : PriceRepository {
    override suspend fun save(price: Price) {

    }

    override suspend fun retrieveDollarPrice(): Price {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDollarPriceToday(): BaseResponse<Price> =
        priceRemoteResource.getDollarPriceToday()
}