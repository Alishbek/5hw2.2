package com.example.a5hw22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5hw22.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var firstName: String
    lateinit var secondName: String
    lateinit var percentage: String
    lateinit var result: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener {
            getRequest()
        }

    }

    private fun getRequest() {
        App.api.getPercentage(binding.etSname.text.toString(), binding.etFname.text.toString())
            .enqueue(
                object : Callback<CalculateModel> {
                    override fun onResponse(
                        call: Call<CalculateModel>,
                        response: Response<CalculateModel>
                    ) {
                        firstName = response.body()?.firstName.toString()
                        secondName = response.body()?.secondName.toString()
                        percentage = response.body()?.percentage.toString()
                        result = response.body()?.result.toString()
                        secondActivity()
                    }

                    override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    }


                }
            )
    }
    fun secondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("fname", firstName)
        intent.putExtra("sname", secondName)
        intent.putExtra("percentage", percentage)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}