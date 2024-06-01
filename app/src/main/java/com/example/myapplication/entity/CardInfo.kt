package com.example.myapplication.entity

interface CardInfo {
    val number: NumberCard?
    val scheme: String?
    val type: String?
    val brand: String?
    val prepaid: Boolean?
    val country: CountryCard?
    val bank: BankInfo?
}
