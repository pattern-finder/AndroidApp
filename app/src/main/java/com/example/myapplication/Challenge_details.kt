package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myapplication.Recyclerview.ChallengeViewHolder
import com.example.myapplication.Recyclerview.DetailAdapter
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

 class Challenge_details : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_details)


        var user_name = findViewById<EditText>(R.id.et_user_name)
        val instruc = findViewById<TextView>(R.id.textView2)


        val id = intent.getStringExtra("ayoub")
        val instuction = intent.getStringExtra("instru")

        instruc.text = instuction
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        val serviceGenerator = ApiClient.buildService(DetailInterface::class.java)

        val call  = serviceGenerator.getDetailChallenge(id!!)

        call.enqueue(object : Callback<DetailModel>{
            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                t.printStackTrace()

            }

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {

                if (response.isSuccessful){

                    recyclerView.apply {
                        recyclerView.layoutManager = GridLayoutManager(this@Challenge_details,2)
                        adapter = DetailAdapter(response.body()!!)
                    }
                }
            }

        })


/*
        val image = findViewById<ImageView>(R.id.item_image)

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
*/

    }
}