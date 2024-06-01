package com.example.myapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.entity.CardInfo

@Entity(tableName = "card")
data class CardDTO (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long?,
    @Embedded
    override val number: NumberCardDTO?,
    @ColumnInfo(name = "scheme")
    override val scheme: String?,
    @ColumnInfo(name = "type")
    override val type: String?,
    @ColumnInfo(name = "brand")
    override val brand: String?,
    @ColumnInfo(name = "prepaid")
    override val prepaid: Boolean?,
    @Embedded(prefix = "country_")
    override val country: CountryCardDTO,
    @Embedded(prefix = "bank_")
    override val bank: BankDTO
) : CardInfo
