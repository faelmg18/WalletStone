package br.com.rafaelhfernandes.core.data.price

import br.com.rafaelhfernandes.core.domain.entities.Brita
import br.com.rafaelhfernandes.core.domain.reposotories.PriceRemoteResource
import br.com.rafaelhfernandes.core.domain.reposotories.BritaRepository
import br.com.rafaelhfernandes.core.framework.model.BaseResponse
import javax.inject.Inject

class BritaRepositoryImpl @Inject constructor(
    private val priceRemoteResource: PriceRemoteResource
) : BritaRepository {
    override suspend fun save(brita: Brita) {

    }

    override suspend fun retrieveDollarPrice(): Brita {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getDollarPriceToday(): BaseResponse<Brita> =
        priceRemoteResource.getDollarPriceToday()
}