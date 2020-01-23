package br.com.rafaelhfernandes.core.data.price

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.rafaelhfernandes.core.domain.entities.Brita

@Dao
abstract class PriceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(brita: Brita): Long

    @Query("SELECT * FROM Brita")
    abstract suspend fun findAll(): MutableList<Brita>

}