package com.example.myapplication.data

import com.example.myapplication.data.model.CardDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import javax.inject.Inject

class SearchRepository @Inject constructor(private val cardDao: CardDao) {
    fun getDataFromNetwork(cardNumber: Long): Call<CardDTO> {
        return MyRetrofit.searchCard.getInfo(cardNumber)
    }

    fun getDataFromDatabase(): Flow<List<CardDTO>> {
        return cardDao.getAll()
    }
}
