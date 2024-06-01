package com.example.myapplication.domain

import com.example.myapplication.data.SaveRepository
import com.example.myapplication.data.SearchRepository
import com.example.myapplication.data.model.CardDTO
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class GetCardFromNetworkUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    private val saveRepository: SaveRepository
) {
    suspend fun getAndSaveData(cardNumber: Long): Response<CardDTO> {
        val answer = searchRepository.getDataFromNetwork(cardNumber).awaitResponse()
        if (answer.isSuccessful) {
            answer.body()?.let { saveRepository.saveData(it) }
        }
        return answer
    }
}
