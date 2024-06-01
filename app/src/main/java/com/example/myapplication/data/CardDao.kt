package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.model.CardDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Query("SELECT * FROM card")
    fun getAll() : Flow<List<CardDTO>>

    @Insert
    suspend fun insert(cardDTO: CardDTO)
}
