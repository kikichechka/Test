package com.example.myapplication.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.presenter.viewmodel.SearchViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val searchViewModel: SearchViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return searchViewModel as T
        }
        throw IllegalArgumentException("Unknown classssss name")
    }
}