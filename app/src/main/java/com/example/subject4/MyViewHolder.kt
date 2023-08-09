package com.example.subject4

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val view = itemView
    private val checkboxId = view.findViewById<CheckBox>(R.id.checkbox)
    fun bind(viewModel: ViewModel, position:Int) {
        view.rootView.setOnClickListener {

            viewModel.isChecked = !viewModel.isChecked

            checkboxId.isChecked = viewModel.isChecked
        }
        checkboxId.isChecked = viewModel.isChecked

        checkboxId.text = viewModel.label
    }

    data class ViewModel(
        val label:String,
        var isChecked: Boolean
    )
}