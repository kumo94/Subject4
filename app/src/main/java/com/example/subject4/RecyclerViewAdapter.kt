package com.example.subject4

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(
    private val list: List<String>
    ) : RecyclerView.Adapter<MyViewHolder>() {
    val viewModels = list.map { MyViewHolder.ViewModel(it, false) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemVIew = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(viewModel = viewModels[position], position)
    }

    override fun getItemCount(): Int = list.size

}