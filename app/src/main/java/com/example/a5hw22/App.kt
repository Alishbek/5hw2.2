package com.example.a5hw22


import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application()

//    companion object {
//        lateinit var api: CalculatorApi
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        val retrofit = RetrofitService()
//        api = retrofit.getApi()
//    }
//}