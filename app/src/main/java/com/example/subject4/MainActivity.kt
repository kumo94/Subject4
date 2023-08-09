package com.example.subject4

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefectures = resources.getStringArray(R.array.prefectures).toList()
        val adapter = RecyclerViewAdapter(prefectures)
        findViewById<RecyclerView>(R.id.recycler_view).adapter = adapter



        findViewById<Button>(R.id.ok_btn).setOnClickListener {
            var prefecture = ""
            for (i in 0..46) {
                if (adapter.viewModels[i].isChecked) {
                    prefecture = if (prefecture.isEmpty()) {
                        adapter.viewModels[i].label
                    } else {
                        "$prefecture,${adapter.viewModels[i].label}"
                    }
                }
            }
            Toast.makeText(this, prefecture, Toast.LENGTH_SHORT).show()
        }
    }
}