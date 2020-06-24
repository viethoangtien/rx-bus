package com.soict.hoangviet.rxbus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soict.hoangviet.rxbus.R
import kotlinx.android.synthetic.main.layout_item.view.*

class PersonAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val listModel: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listModel.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PersonViewHolder).bind(listModel[position])
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: String) {
            itemView.tv_name.text = data
        }
    }

    fun addModels(list: List<String>) {
        listModel.addAll(list)
        notifyItemRangeInserted(itemCount, list.size)
    }

    fun addModel(data: String) {
        listModel.add(data)
        notifyItemInserted(itemCount)
    }
}