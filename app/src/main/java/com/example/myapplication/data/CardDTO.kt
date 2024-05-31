package com.example.myapplication.data

import com.example.myapplication.entity.CardInfo

class CardDTO(
    override val number: NumberCardDTO,
    override val scheme: String,
    override val type: String,
    override val brand: String,
    override val prepaid: Boolean,
    override val country: CountryCardDTO,
    override val bank: BankDTO
) : CardInfo
