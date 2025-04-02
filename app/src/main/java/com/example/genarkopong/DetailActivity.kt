package com.example.genarkopong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val imageList = listOf(
            R.drawable.images, // Ganti dengan resource gambar Anda
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images
        )

        val textList = listOf(
            "Gambar 1",
            "Gambar 2",
            "Gambar 3",
            "Gambar 4",
            "Gambar 5",
            "Gambar 6",
            "Gambar 7"
        )

        val adapter = MyAdapter(imageList, textList)
        recyclerView.adapter = adapter
    }
}