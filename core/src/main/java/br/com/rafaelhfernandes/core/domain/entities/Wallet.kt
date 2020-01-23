package br.com.rafaelhfernandes.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wallet(
    @PrimaryKey(autoGenerate = true)  val userId: Long,
    val balance: Double
)