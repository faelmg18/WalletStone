package br.com.rafaelhfernandes.core.framework.price.data

import br.com.rafaelhfernandes.core.data.price.PriceDao
import br.com.rafaelhfernandes.core.data.price.BritaDataSource
import br.com.rafaelhfernandes.core.domain.entities.Brita
import javax.inject.Inject

class BritaDataSourceImpl @Inject constructor(val priceDao: PriceDao) : BritaDataSource {

    override suspend fun save(brita: Brita): Long = priceDao.insert(brita)

    override suspend fun retrieveBrita(): Brita? = if (priceDao.findAll().isNotEmpty())
        priceDao.findAll()[0]
    else
        null

}