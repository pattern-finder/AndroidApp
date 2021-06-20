package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.api.user.model.LoginModel
import com.example.myapplication.api.user.model.UserModel
import com.example.myapplication.api.user.serivce.ProfileUserService

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val full_name = findViewById<TextView>(R.id.fullName)
        val email = findViewById<TextView>(R.id.email)

        ProfileUserService().UserProfile()

        email.text = "hellow"


    }

}