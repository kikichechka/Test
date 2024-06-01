package com.example.myapplication.data.converter
import androidx.room.TypeConverter

class ConvertersBoolean {
    @TypeConverter
    fun fromLocalDate(data: Boolean): Int {
        return if (data) 1 else 0
    }

    @TypeConverter
    fun toLocation(data: Int): Boolean {
        return data != 0
    }
}
