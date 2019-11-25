package br.com.rafaelhfernandes.core.data.price

import br.com.rafaelhfernandes.core.domain.entities.Price

interface PriceDataSource {
    suspend fun retrieveDollar(): Price?
    suspend fun save(price: Price):Long
}