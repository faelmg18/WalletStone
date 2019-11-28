package br.com.rafaelhfernandes.core.framework.loginlogoutmanager

import br.com.rafaelhfernandes.core.data.loginlogoutmanager.LoginLogoutManagerDao
import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.domain.reposotories.LoginLogoutManagerRepository

class LoginLogoutManagerDataSource(private val loginLogoutManagerDao: LoginLogoutManagerDao) :
    LoginLogoutManagerRepository {

    override suspend fun retrieveUserLogged(): User? {
        return loginLogoutManagerDao.retrieveUserLogged()?.user
    }

    override suspend fun insert(loginLogoutManager: LoginLogoutManager): Long {
        return loginLogoutManagerDao.save(loginLogoutManager)
    }

    override suspend fun delete(loginLogoutManager: LoginLogoutManager) {
        return loginLogoutManagerDao.delete(loginLogoutManager)
    }

}