package com.example.myapplication.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val searchViewModel: SearchViewModel,
    private val historyViewModel: HistoryViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return searchViewModel as T
        }
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return historyViewModel as T
        }
        throw IllegalArgumentException("Unknown classssss name")
    }
}