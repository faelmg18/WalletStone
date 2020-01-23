package br.com.rafaelhfernandes.core.data.wallet

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.rafaelhfernandes.core.domain.entities.Wallet

@Dao
abstract class WalletDao {

    @Query("Select * from Wallet where userId=:userId")
    abstract suspend fun retrieveBalance(userId: Long): Wallet

    @Query("update wallet set balance =:value where userId=:userId")
    abstract suspend fun updateBalance(value: Double, userId: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(wallet: Wallet): Long
}