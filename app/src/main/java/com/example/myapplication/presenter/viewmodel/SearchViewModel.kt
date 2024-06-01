package com.example.myapplication.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CardDTO
import com.example.myapplication.domain.GetCardFromNetworkUseCase
import com.example.myapplication.entity.StateType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getCardFromNetworkUseCase: GetCardFromNetworkUseCase
) : ViewModel() {
    private val _dataStateFlow = MutableStateFlow<CardDTO?>(null)
    val dataStateFlow = _dataStateFlow.asStateFlow()

    private val _stateShow = MutableLiveData<StateType>(StateType.Hide(null))
    val stateShow: LiveData<StateType> = _stateShow

    suspend fun getData(cardNumber: Long) {
        val response = getCardFromNetworkUseCase.getAndSaveData(cardNumber)
        _stateShow.value = StateType.Loading
        when (response.code()) {
            CODE_NOT_FOUND -> {
                _stateShow.value = StateType.Hide(CARD_NOT_FOUND)
            }
            CODE_LIMIT -> {
                _stateShow.value = StateType.Hide(LIMIT_REQUEST)
            }
            CODE_OK -> {
                _dataStateFlow.value = response.body()
                _stateShow.value = StateType.Display
            }
            else -> _stateShow.value = StateType.Hide(UNKNOWN_ERROR)
        }
    }

    companion object {
        private const val CARD_NOT_FOUND = "Карта не найдена"
        private const val LIMIT_REQUEST = "Превышен лимит запросов"
        private const val UNKNOWN_ERROR = "Неизвестная ошибка"
        private const val CODE_OK = 200
        private const val CODE_LIMIT = 429
        private const val CODE_NOT_FOUND = 404
    }
}
