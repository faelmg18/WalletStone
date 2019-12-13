package br.com.rafaelhfernandes.core.framework

import android.content.Context
import br.com.rafaelhfernandes.core.data.database.WalletStoneDataBaseClient
import br.com.rafaelhfernandes.core.data.price.BritaDataSource
import br.com.rafaelhfernandes.core.domain.reposotories.LoginLogoutManagerRepository
import br.com.rafaelhfernandes.core.domain.reposotories.UserRepository
import br.com.rafaelhfernandes.core.domain.reposotories.WalletRepository
import br.com.rafaelhfernandes.core.framework.loginlogoutmanager.LoginLogoutManagerDataSource
import br.com.rafaelhfernandes.core.framework.price.data.BritaDataSourceImpl
import br.com.rafaelhfernandes.core.framework.user.data.UserDataSource
import br.com.rafaelhfernandes.core.framework.wallet.data.WalletDataSource

class RepositoryFactory internal constructor(context: Context) {

    private val dataBase = WalletStoneDataBaseClient.getInstance(context)

    companion object : SingletonHolder<RepositoryFactory, Context>({
        RepositoryFactory(context = it.applicationContext)
    })

    fun createBritaRepositories(): BritaDataSource {
        return BritaDataSourceImpl(dataBase.priceDao)
    }

    fun createUserRepositories(): UserRepository {
        return UserDataSource(dataBase.userDao)
    }

    fun createLoginLogoutManagerRepositories(): LoginLogoutManagerRepository {
        return LoginLogoutManagerDataSource(dataBase.loginLogoutManagerDao)
    }

    fun creatWalletRepositories(): WalletRepository {
        return WalletDataSource(dataBase.walletDao)
    }
}
