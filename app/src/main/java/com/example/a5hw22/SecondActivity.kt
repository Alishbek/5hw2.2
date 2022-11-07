package com.example.a5hw22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5hw22.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvFname.text = intent.getStringExtra("fname")
        binding.tvSname.text = intent.getStringExtra("sname")
        binding.tvPercentage.text = intent.getStringExtra("percentage").toString()+"%"
        binding.tvResult.text = intent.getStringExtra("result")
        binding.btnTryAgain.setOnClickListener { mainActivity() }
    }

    fun mainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}