package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*


class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val button = findViewById<Button>(R.id.btnToWebsite)

        btnToWebsite.setOnClickListener {

            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://picspy-frontend.herokuapp.com/sign-up"))
                startActivity(browserIntent)
        }

    }
}