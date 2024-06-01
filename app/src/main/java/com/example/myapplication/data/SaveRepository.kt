package com.example.myapplication.data

import com.example.myapplication.data.model.CardDTO
import javax.inject.Inject

class SaveRepository @Inject constructor(private val cardDao: CardDao) {

    suspend fun saveData(cardDTO: CardDTO) {
        cardDao.insert(cardDTO)
    }
}
