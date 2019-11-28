package br.com.rafaelhfernandes.core.domain.reposotories

import br.com.rafaelhfernandes.core.domain.entities.User

interface UserRepository {
    suspend fun retrieveUser(id: Long): User?
    suspend fun retrieveUserByEmailOrUserName(email: String, userName: String): User?
    suspend fun retrieveUserByNameOrEmailAndPassword(email: String, userPassword: String): User?
    suspend fun save(user: User): Long
    suspend fun delete(user: User)
    suspend fun update(user: User)
}