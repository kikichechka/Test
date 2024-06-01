package com.example.myapplication.data

import com.example.myapplication.data.model.BankDTO
import com.example.myapplication.data.model.CardDTO
import com.example.myapplication.data.model.CountryCardDTO
import com.example.myapplication.data.model.NumberCardDTO
import retrofit2.Call
import javax.inject.Inject

class SearchRepository @Inject constructor() {
    suspend fun getDataFromNetwork(cardNumber: Long): Call<CardDTO> {
        return MyRetrofit.searchCard.getInfo(cardNumber)
    }

    suspend fun getDataFromDataBase(cardNumber: Long) : CardDTO {
        return CardDTO(
            number = NumberCardDTO(16, true),
            scheme = "visa",
            type = "debit",
            brand = "Visa/Dankort",
            prepaid = false,
            country = CountryCardDTO(
                name = "Denmark",
                latitude = 56868686L,
                longitude = 108686988986L
            ),
            bank = BankDTO(
                name = "Jyske Bank",
                url = "www.jyskebank.dk",
                phone = "+4589893300",
                city = "Hjørring"
            )
        )
    }
}
