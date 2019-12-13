package br.com.rafaelhfernandes.core.data.price

import br.com.rafaelhfernandes.core.domain.entities.Brita

interface BritaDataSource {
    suspend fun retrieveBrita(): Brita?
    suspend fun save(brita: Brita):Long
}