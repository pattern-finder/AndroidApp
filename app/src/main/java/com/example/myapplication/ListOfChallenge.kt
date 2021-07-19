package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Recyclerview.ChallengeAdapter
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.user.controller.ChallengeInterface
import com.example.myapplication.api.user.model.ChallengeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListOfChallenge : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_challenge)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val serviceGenerator = ApiClient.buildService(ChallengeInterface::class.java)
        val call = serviceGenerator.getChallenges()
        call.enqueue(object : Callback<ChallengeModel>{
            override fun onFailure(call: Call<ChallengeModel>, t: Throwable) {

                d("ayoub","nooooo")
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<ChallengeModel>,
                response: Response<ChallengeModel>
            ) {
                if(response.isSuccessful){
                    Log.e("ayoub",response.body().toString())
                    recyclerView.apply {

                        layoutManager = LinearLayoutManager(this@ListOfChallenge)
                        adapter = ChallengeAdapter(response.body()!!)
                    }

                }
            }


        })



    }
}