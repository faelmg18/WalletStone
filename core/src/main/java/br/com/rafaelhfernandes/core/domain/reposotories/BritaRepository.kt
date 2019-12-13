package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.Brita
import br.com.rafaelhfernandes.core.framework.model.BaseResponse

interface BritaRepository {
    suspend fun getDollarPriceToday(): BaseResponse<Brita>
    suspend fun retrieveDollarPrice(): Brita
    suspend fun save(brita: Brita)
}