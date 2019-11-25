package br.com.rafaelhfernandes.core.framework

import android.content.Context
import br.com.rafaelhfernandes.core.data.database.WalletStoneDataBaseClient
import br.com.rafaelhfernandes.core.data.price.PriceDataSource
import br.com.rafaelhfernandes.core.framework.price.data.PriceDataSourceImpl

class RepositoryFactory internal constructor(context: Context) {

    private val dataBase = WalletStoneDataBaseClient.getInstance(context)

    companion object : SingletonHolder<RepositoryFactory, Context>({
        RepositoryFactory(context = it.applicationContext)
    })


    fun createPriceRepositories(): PriceDataSource {
        return PriceDataSourceImpl(dataBase.priceDao)
    }

}
