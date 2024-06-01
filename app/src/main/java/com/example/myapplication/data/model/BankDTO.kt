package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import com.example.myapplication.entity.BankInfo

class BankDTO (
    @ColumnInfo(name = "name")
    override val name: String?,
    @ColumnInfo(name = "url")
    override val url: String?,
    @ColumnInfo(name = "phone")
    override val phone: String?,
    @ColumnInfo(name = "city")
    override val city: String?
) : BankInfo
