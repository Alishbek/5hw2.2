package com.example.a5hw22

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.a5hw22.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    lateinit var firstName: String
    lateinit var secondName: String
    lateinit var percentage: String
    lateinit var result: String

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val isShow: Boolean = sharedPreferences.getBoolean("isShow", true)
        if (isShow) {
            onBoard()
        }
        binding.btnCalculate.setOnClickListener {
            getRequest()
        }

    }

    private fun getRequest() {
//        App.api.getPercentage(binding.etSname.text.toString(), binding.etFname.text.toString())
//            .enqueue(
//                object : Callback<CalculateModel> {
//                    override fun onResponse(
//                        call: Call<CalculateModel>,
//                        response: Response<CalculateModel>
//                    ) {
//                        firstName = response.body()?.firstName.toString()
//                        secondName = response.body()?.secondName.toString()
//                        percentage = response.body()?.percentage.toString()
//                        result = response.body()?.result.toString()
//                        secondActivity()
//                    }
//
//                    override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
//                    }
//
//
//                }
//            )
        viewModel.getRequest(binding.etFname.text.toString(), binding.etSname.text.toString())
            .observe(this@MainActivity, {
                firstName = it.firstName
                secondName = it.secondName
                percentage = it.percentage
                result = it.result
                secondActivity()
            })
    }

    fun onBoard() {
        val intent = Intent(this, OnBoard::class.java)
        startActivity(intent)
        sharedPreferences.edit().putBoolean("isShow", false).apply()
    }

    fun secondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("fname", firstName)
        intent.putExtra("sname", secondName)
        intent.putExtra("percentage", percentage)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}