package br.com.rafaelhfernandes.core.data.database

import android.content.Context
import androidx.room.Room
import br.com.rafaelhfernandes.core.data.database.WalletStoneDataBase.Companion.DATA_BASE_NAME
import br.com.rafaelhfernandes.core.framework.SingletonHolder

abstract class WalletStoneDataBaseClient {

    companion object : SingletonHolder<WalletStoneDataBase, Context>({
        Room.databaseBuilder(
            it.applicationContext,
            WalletStoneDataBase::class.java, DATA_BASE_NAME
        ).build()
    })

}
