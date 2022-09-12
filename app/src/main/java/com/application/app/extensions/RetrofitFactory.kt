package com.application.app.extensions

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val URL: String = "https://localhost:7250/api/"

    val retrofitFactory = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun retrofitService(): RetrofitService{
        return retrofitFactory.create(RetrofitService::class.java)
    }
}