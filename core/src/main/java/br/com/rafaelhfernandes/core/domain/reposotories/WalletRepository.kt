package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.Wallet

interface WalletRepository {

    suspend fun retrieveBalance(userId: Long): Wallet

    suspend fun updateBalance(value: Double, userId: Long)

    suspend fun insert(wallet: Wallet): Long

}