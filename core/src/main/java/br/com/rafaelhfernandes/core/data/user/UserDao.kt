package br.com.rafaelhfernandes.core.data.user

import androidx.room.*
import br.com.rafaelhfernandes.core.domain.entities.User

@Dao
abstract class UserDao {

    @Query("select * from User where id = :id")
    abstract suspend fun retrieveUser(id: Long): User?

    @Query("select * from User where email = :email or userName =:userName")
    abstract suspend fun retrieveUserByEmailOrUserName(email: String, userName: String): User?

    @Query("select * from User where (email = :userNameOrEmail or userName=:userNameOrEmail) and password =:userPassword")
    abstract suspend fun retrieveUserByNameOrEmailAndPassword(userNameOrEmail: String, userPassword: String): User?

    @Query("Select * from User")
    abstract suspend fun retrieveAllUser(): MutableList<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(user: User): Long

    @Delete
    abstract suspend fun delete(user: User)

    @Update
    abstract suspend fun update(user: User): Int

    suspend fun insertNewUser(user: User): Long {
        val userFromDB = retrieveUserByEmailOrUserName(user.email, user.userName)
        val result: Long
        result = if (userFromDB == null)
            save(user)
        else -1
        return result
    }

    suspend fun insertOrUpdate(user: User): Long {
        val userFromDB = retrieveUserByEmailOrUserName(user.email, user.userName)
        val result: Long
        result = if (userFromDB == null)
            save(user)
        else
            update(user).toLong()

        return result
    }
}