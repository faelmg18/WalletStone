package br.com.rafaelhfernandes.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userName: String,
    val email: String,
    val password: String,
    val pinCode: String
)