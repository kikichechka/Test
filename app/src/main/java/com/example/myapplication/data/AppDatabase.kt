package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.data.converter.ConvertersBoolean
import com.example.myapplication.data.model.CardDTO

@Database(entities = [CardDTO::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    @TypeConverters(
        ConvertersBoolean::class
    )
    abstract fun cardDao() : CardDao
}
