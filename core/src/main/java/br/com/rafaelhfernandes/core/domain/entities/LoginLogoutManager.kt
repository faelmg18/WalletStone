package br.com.rafaelhfernandes.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginLogoutManager(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val user: User
)