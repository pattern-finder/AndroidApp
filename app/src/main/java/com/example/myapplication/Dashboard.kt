package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var loginButton  = findViewById<Button>(R.id.loginId)
        var about = findViewById<ImageView>(R.id.about)

        loginButton.setOnClickListener {

            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        about.setOnClickListener{

            intent= Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }


    }
}