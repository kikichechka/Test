package com.example.myapplication.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.CardDTO
import com.example.myapplication.domain.GetCardsDataBaseUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getCardsDataBaseUseCase: GetCardsDataBaseUseCase
) : ViewModel() {
    private val _listData = MutableLiveData<List<CardDTO>>()
    val listData: LiveData<List<CardDTO>> = _listData

    init {
        viewModelScope.launch {
            getListData()
        }
    }

    private suspend fun getListData() {
        getCardsDataBaseUseCase.getListData().collect{
            _listData.value = it
        }
    }
}
