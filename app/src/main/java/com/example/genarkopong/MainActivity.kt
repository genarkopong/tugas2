package com.example.genarkopong

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import android.content.SharedPreferences

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

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

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Membuka Profil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, profile_menu::class.java)) // Pastikan ProfileActivity ada
            }
            R.id.nav_about -> {
                Toast.makeText(this, "Membuka Tentang", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, about_menu::class.java)) // Pastikan AboutActivity ada
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()


                val sharedPreferences: SharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE) // Ganti "user_session" dengan nama SharedPreferences Anda
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.remove("isLoggedIn")
                editor.apply()

                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
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
            val uri = Uri.parse("market://details?id=com.whatsapp")
            val goToMarket = Intent(Intent.ACTION_VIEW, uri)
            startActivity(goToMarket)
        }
    }
}