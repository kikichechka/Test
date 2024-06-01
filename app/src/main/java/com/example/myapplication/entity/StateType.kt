package com.example.myapplication.entity

sealed class StateType {
    data object Display : StateType()

    data class Hide(var error: String?) : StateType()

    data object Loading : StateType()
}
