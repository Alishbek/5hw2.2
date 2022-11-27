package com.example.a5hw22

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: CalculatorApi) {

    fun getRequest(firstName: String, secondName: String): MutableLiveData<CalculateModel> {
        val calculateLiveData = MutableLiveData<CalculateModel>()
        api.getPercentage(firstName, secondName).enqueue(
            object : Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
                    if (response.isSuccessful) {
                        calculateLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )

        return calculateLiveData
    }
}