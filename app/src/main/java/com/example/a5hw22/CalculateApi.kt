package com.example.a5hw22

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//.url("https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John")
//.get()
//.addHeader("X-RapidAPI-Key", "6730835a9fmsh4532cf4345cb5fep1f2d74jsn0b57516c19df")
//.addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
//.build()

interface CalculatorApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") key: String = "6730835a9fmsh4532cf4345cb5fep1f2d74jsn0b57516c19df",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<CalculateModel>
}