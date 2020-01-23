package br.com.rafaelhfernandes.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.rafaelhfernandes.core.data.database.WalletStoneDataBase.Companion.VERSION
import br.com.rafaelhfernandes.core.data.database.util.UserConvert
import br.com.rafaelhfernandes.core.data.loginlogoutmanager.LoginLogoutManagerDao
import br.com.rafaelhfernandes.core.data.price.PriceDao
import br.com.rafaelhfernandes.core.data.user.UserDao
import br.com.rafaelhfernandes.core.data.wallet.WalletDao
import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.Brita
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.domain.entities.Wallet

@Database(
    entities = [Brita::class, User::class, LoginLogoutManager::class, Wallet::class],
    version = VERSION
)
@TypeConverters(UserConvert::class)
abstract class WalletStoneDataBase : RoomDatabase() {

    abstract val priceDao: PriceDao
    abstract val userDao: UserDao
    abstract val loginLogoutManagerDao: LoginLogoutManagerDao
    abstract val walletDao: WalletDao

    companion object {
        const val VERSION = 1
        const val DATA_BASE_NAME = "WalletStoneDataBase-db"
    }
}