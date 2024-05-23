package com.example.olim_prototip.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olim_prototip.data.model.QuestionData
import com.example.olim_prototip.databinding.ItemQuestBinding

class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {
    var list = ArrayList<QuestionData>()
    var itemClick: ((id: Int) -> Unit)? = null

    inner class ViewHolder(private var binding: ItemQuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                itemClick?.invoke(
                    list[adapterPosition].id
                )

            }
        }

        fun bind(data: QuestionData) {
            binding.text.text = data.text
            if (data.isDone) {
                binding.checkImage.visibility = View.VISIBLE
            } else
                binding.checkImage.visibility = View.INVISIBLE
            if (data.isDone) {
                binding.card.setCardBackgroundColor(Color.parseColor("#33FF00"))
            } else
                binding.card.setCardBackgroundColor(Color.RED)
            if (data.isDone) {
                binding.text.setTextColor(Color.parseColor("#FFD600"))
            } else
                binding.text.setTextColor(Color.WHITE)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding = binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}