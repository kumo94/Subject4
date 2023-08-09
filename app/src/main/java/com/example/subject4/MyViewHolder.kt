package com.example.subject4

import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val view = itemView
    private val checkboxId = view.findViewById<CheckBox>(R.id.checkbox)
    fun bind(viewModel: ViewModel, position:Int) {
        view.rootView.setOnClickListener {
            // アイテムクリック時にイベントをキャッチ
            // (今回の場合は)わざわざonItemClickListenerを呼び出す必要はない

            // アイテムタップ時にタップ状態を反転させる
            viewModel.isChecked = !viewModel.isChecked

            // 反転させたチェック状態をチェックボックスに反映
            // チェックボックスの状態たちを保持しているのはViewModel
            checkboxId.isChecked = viewModel.isChecked
        }
        // bindが呼び出されたタイミングで今現在ViewModelが持っているチェック状態を反映
        checkboxId.isChecked = viewModel.isChecked

        checkboxId.text = viewModel.label
    }

    data class ViewModel(
        val label:String,
        var isChecked: Boolean
    )
}