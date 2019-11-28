package br.com.rafaelhfernandes.core.data.database.util

import androidx.room.TypeConverter
import br.com.rafaelhfernandes.core.domain.entities.User
import com.google.gson.Gson

class UserConvert {
    //room will automatically convert custom obj into string and store in DB
    @TypeConverter
    fun convertUserToJson(user: User): String {
        val gson = Gson()
        return gson.toJson(user)
    }

    //At the time of fetching records room will automatically convert string to
    // respective obj
    @TypeConverter
    fun toMappedUser(value: String): User? {
        return Gson().fromJson(value, User::class.java)
    }
}