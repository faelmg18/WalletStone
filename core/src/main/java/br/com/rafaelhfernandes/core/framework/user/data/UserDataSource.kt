package br.com.rafaelhfernandes.core.framework.user.data

import br.com.rafaelhfernandes.core.data.user.UserDao
import br.com.rafaelhfernandes.core.domain.entities.User
import br.com.rafaelhfernandes.core.domain.reposotories.UserRepository

class UserDataSource(private val userDao: UserDao) : UserRepository {
    override suspend fun retrieveUserByEmailOrUserName(email: String, userName: String): User? {
        return userDao.retrieveUserByEmailOrUserName(email, userName)
    }

    override suspend fun retrieveUserByNameOrEmailAndPassword(
        email: String,
        userPassword: String
    ): User? {
        return userDao.retrieveUserByNameOrEmailAndPassword(email, userPassword)
    }

    override suspend fun retrieveUser(id: Long): User? {
        return userDao.retrieveUser(id)
    }

    override suspend fun save(user: User): Long {
        return userDao.insertNewUser(user)
    }

    override suspend fun delete(user: User) {
        userDao.delete(user)
    }

    override suspend fun update(user: User) {
        userDao.update(user)
    }
}