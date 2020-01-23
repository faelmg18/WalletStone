package br.com.rafaelhfernandes.core.framework.wallet.data

import br.com.rafaelhfernandes.core.data.wallet.WalletDao
import br.com.rafaelhfernandes.core.domain.entities.Wallet
import br.com.rafaelhfernandes.core.domain.reposotories.WalletRepository

class WalletDataSource(private val walletDao: WalletDao) : WalletRepository {

    override suspend fun retrieveBalance(userId: Long): Wallet {
        return walletDao.retrieveBalance(userId)
    }

    override suspend fun updateBalance(value: Double, userId: Long) {
        walletDao.updateBalance(value, userId)
    }

    override suspend fun insert(wallet: Wallet): Long = walletDao.insert(wallet)

}