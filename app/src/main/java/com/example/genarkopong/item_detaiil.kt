package com.example.genarkopong

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_detaiil)

        val imageViewDetail: ImageView = findViewById(R.id.imageViewDetail)
        val textViewDetailTitle: TextView = findViewById(R.id.textViewDetailTitle)
        val textViewDetailDescription: TextView? = findViewById(R.id.textViewDetailDescription) // Jika ada deskripsi

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val intent = intent
        if (intent != null) {
            val imageResource = intent.getIntExtra("image_resource", 0)
            val title = intent.getStringExtra("text")
            val description = intent.getStringExtra("description")


            imageViewDetail.setImageResource(imageResource)
            textViewDetailTitle.text = title


            description?.let {
                textViewDetailDescription?.text = it
            }
        }
    }
}