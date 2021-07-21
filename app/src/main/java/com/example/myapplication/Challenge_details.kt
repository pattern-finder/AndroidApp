package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.user.controller.DetailInterface

import com.example.myapplication.api.user.model.DetailModel
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_challenge_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Url
import java.net.URL

@Suppress("DEPRECATION")
class Challenge_details : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_details)

        val image = findViewById<ImageView>(R.id.imageView)

        val request = ApiClient.buildService(DetailInterface::class.java)
        val call = request.getDetailChallenge()

        call.enqueue(object : Callback<DetailModel> {
            override fun onResponse(call: Call<DetailModel>?, response: Response<DetailModel>?) {

                val detailReponse = response?.body()

                if (response !== null) {
                    if(response.isSuccessful) {


                        //val url = "https://minio.picspy.vagahbond.com/picspy-challenges/test_challenge/6fac9614-3dcb-41d4-839a-c254f144eadf1626017203650.png"
                        val url = detailReponse!!.content!!.pictures!![1]!!.file

                        val changeUrl1 = url!!.replace("http","https")
                        val changeUrl2 = changeUrl1.replace(":80","")
                        Glide.with(this@Challenge_details)
                            .load(changeUrl2).dontAnimate()
                            .skipMemoryCache(true) //2
                            .diskCacheStrategy(DiskCacheStrategy.NONE) //3
                            .into(image)

                        //name.text = detailReponse.content!!.pictures!![0]!!.id

                        Toast.makeText(this@Challenge_details,changeUrl2, Toast.LENGTH_LONG).show();


                    }
                }
            }
            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                error("KO")
            }
        })


    }
}