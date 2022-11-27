package com.example.a5hw22

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a5hw22.databinding.ItemBoardBinding

class BoardAdapter(
    private val list: ArrayList<BoardModel>,
    private val listener: PageClickListener
) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
    inner class BoardViewHolder(
        private val binding: ItemBoardBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(boardModel: BoardModel) {
            binding.tvBoard.text = boardModel.boardName
            binding.btnNext.setOnClickListener {
                listener.pageClick()
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}