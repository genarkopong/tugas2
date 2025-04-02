package com.example.genarkopong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button WhatsApp
        val btnWhatsApp: Button = findViewById(R.id.btn_whatsapp)
        btnWhatsApp.setOnClickListener {
            openWhatsApp()
        }

        // Button Recycler
        val btnRecycler: Button = findViewById(R.id.btn_recycler)
        btnRecycler.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openWhatsApp() {
        val phoneNumber = "6281344894791"
        val message = "Halo kamu felix yha!"

        try {
            val uri = Uri.parse("smsto:$phoneNumber")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.setPackage("com.whatsapp")
            intent.putExtra("sms_body", message)
            startActivity(intent)
        } catch (e: android.content.ActivityNotFoundException) {
            // WhatsApp tidak terpasang
            val uri = Uri.parse("market://details?id=com.whatsapp")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            startActivity(goToMarket)
        }
    }
}