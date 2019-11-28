package br.com.rafaelhfernandes.core.data.loginlogoutmanager

import androidx.room.*
import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.User


@Dao
abstract class LoginLogoutManagerDao {

    @Query("SELECT * FROM LoginLogoutManager ORDER BY id ASC LIMIT 1")
    abstract suspend fun retrieveUserLogged(): LoginLogoutManager?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(user: LoginLogoutManager): Long

    @Delete
    abstract suspend fun delete(user: LoginLogoutManager)
}