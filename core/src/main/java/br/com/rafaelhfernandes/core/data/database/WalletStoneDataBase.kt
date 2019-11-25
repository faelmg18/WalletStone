package br.com.rafaelhfernandes.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rafaelhfernandes.core.data.database.WalletStoneDataBase.Companion.VERSION
import br.com.rafaelhfernandes.core.data.price.PriceDao
import br.com.rafaelhfernandes.core.domain.entities.Price

@Database(entities = [Price::class], version = VERSION)
abstract class WalletStoneDataBase : RoomDatabase() {

    abstract val priceDao: PriceDao

    companion object {
        const val VERSION = 1
        const val DATA_BASE_NAME = "WalletStoneDataBase-db"
    }
}