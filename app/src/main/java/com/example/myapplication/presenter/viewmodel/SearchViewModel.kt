package com.example.myapplication.presenter.viewmodel

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

    private val _stateShow = MutableStateFlow<StateType>(StateType.Hide(null))
    val stateShow = _stateShow.asStateFlow()

    suspend fun getData(cardNumber: Long) {
        _stateShow.value = StateType.Loading
        getCardFromNetworkUseCase.getAndSaveData(cardNumber).apply {
            when (this.code()) {
                CODE_NOT_FOUND -> {
                    _stateShow.value = StateType.Hide(CARD_NOT_FOUND)
                }
                CODE_LIMIT -> {
                    _stateShow.value = StateType.Hide(LIMIT_REQUEST)
                }
                CODE_OK -> {
                    _dataStateFlow.value = this.body()
                    _stateShow.value = StateType.Display
                }
                else -> _stateShow.value = StateType.Hide(UNKNOWN_ERROR)
            }
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
