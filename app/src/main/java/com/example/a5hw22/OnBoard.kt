package com.example.a5hw22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5hw22.databinding.ActivityOnBoardBinding

class OnBoard : AppCompatActivity(), PageClickListener {
    lateinit var binding: ActivityOnBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = arrayListOf<BoardModel>()
        list.add(BoardModel("first board"))
        list.add(BoardModel("SECOND BOARD"))
        list.add(BoardModel("THIIRDDD bbooaoarrd"))
        list.add(BoardModel("FoUrTh BoArD"))
        val boardAdapter = BoardAdapter(list, this)
        binding.viewPager.adapter = boardAdapter
    }

    override fun pageClick() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}