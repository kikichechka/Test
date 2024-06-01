package com.example.myapplication.data

import com.example.myapplication.data.model.CardDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://lookup.binlist.net/"
object MyRetrofit {
    private val retrofit =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchCard: SearchCardApi = retrofit.create(SearchCardApi::class.java)
}

interface SearchCardApi{
    @GET("{cardNumber}")
    fun getInfo(@Path("cardNumber") cardNumber: Long) : Call<CardDTO>
}
