package br.com.rafaelhfernandes.core.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Brita(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val type: Int = 0,
    val cotacaoCompra: Double = 0.0,
    val cotacaoVenda: Double = 0.0,
    val dataHoraCotacao: String = ""
)