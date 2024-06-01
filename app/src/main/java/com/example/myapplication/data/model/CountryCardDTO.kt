package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import com.example.myapplication.entity.CountryCard

class CountryCardDTO (
    @ColumnInfo(name = "name")
    override val name: String?,
    @ColumnInfo(name = "latitude")
    override val latitude: Double?,
    @ColumnInfo(name = "longitude")
    override val longitude: Double?
) : CountryCard
