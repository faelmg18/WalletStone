package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.LoginLogoutManager
import br.com.rafaelhfernandes.core.domain.entities.User

interface LoginLogoutManagerRepository {
    suspend fun retrieveUserLogged(): User?
    suspend fun insert(loginLogoutManager: LoginLogoutManager): Long
    suspend fun delete(loginLogoutManager: LoginLogoutManager)
}