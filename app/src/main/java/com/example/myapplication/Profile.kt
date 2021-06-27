package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.user.controller.UserProfileInterface
import com.example.myapplication.api.user.model.UserContent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var full_name = findViewById<TextView>(R.id.fullName)
        var email = findViewById<TextView>(R.id.email)
        var date = findViewById<TextView>(R.id.CreateAt)
        val profileName = intent.getStringExtra("username")

        val request = ApiClient.buildService(UserProfileInterface::class.java)
        val call = request.getUser()

        call.enqueue(object : Callback<UserContent> {
            override fun onResponse(call: Call<UserContent>?, response: Response<UserContent>?) {

                val userReponse = response?.body()

                if (response !== null) {
                    if(response.isSuccessful) {

                        for(u in userReponse?.content!!){

                            if(u?.username ==profileName){
                                email.text= u!!.email
                                full_name.text= u.username
                                date.text= u.createdAt
                            }

                        }


                        //email.text= userReponse?.content!!.email
                        //Log.d("Response","ma réponse est ${userReponse?.content?.email}")
                       // Log.d("Response","ma réponse est ${userReponse?.content?.email}")
                        //Log.d("Reponse username","le nom de user est ${profileName}")
                    }
                }
            }
            override fun onFailure(call: Call<UserContent>, t: Throwable) {
                error("KO")
            }
        })

    }
 
}