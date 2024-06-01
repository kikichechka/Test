package com.example.myapplication.domain

import com.example.myapplication.data.SearchRepository
import com.example.myapplication.data.model.CardDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardsDataBaseUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) {
    fun getListData(): Flow<List<CardDTO>> {
        return searchRepository.getDataFromDatabase()
    }
}
