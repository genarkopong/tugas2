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
            R.drawable.img,
            R.drawable.senegal,
            R.drawable.argentina,
            R.drawable.francis,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3
        )

        val textList = listOf(
            "Netherland",
            "Senegal",
            "Argentina",
            "France",
            "Switzerland",
            "Croatia",
            "Cuba"
        )

        val descriptionList = listOf(
            "Belanda, dikenal dengan kincir angin dan bunga tulipnya.",
            "Senegal, negara di Afrika Barat dengan budaya yang kaya.",
            "Argentina, terkenal dengan sepak bolanya dan tarian tango.",
            "Prancis, rumah bagi Menara Eiffel dan masakan yang lezat.",
            "Swiss, terkenal dengan pegunungan Alpen dan cokelatnya.",
            "Kroasia, memiliki garis pantai yang indah di Laut Adriatik.",
            "Kuba, pulau Karibia dengan musik salsa dan mobil klasik."
        )

        val adapter = MyAdapter(this, imageList, textList, descriptionList)
        recyclerView.adapter = adapter
    }
}