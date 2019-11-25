package br.com.rafaelhfernandes.core.framework.price.data

import br.com.rafaelhfernandes.core.data.price.PriceDao
import br.com.rafaelhfernandes.core.data.price.PriceDataSource
import br.com.rafaelhfernandes.core.domain.entities.Price
import javax.inject.Inject

class PriceDataSourceImpl @Inject constructor(val priceDao: PriceDao) : PriceDataSource {

    override suspend fun save(price: Price): Long = priceDao.insert(price)

    override suspend fun retrieveDollar(): Price? = if (priceDao.findAll().isNotEmpty())
        priceDao.findAll()[0]
    else
        null

}