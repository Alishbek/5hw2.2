package com.example.a5hw22

import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi(): CalculatorApi{
        return retrofit.create(CalculatorApi::class.java)
    }
}