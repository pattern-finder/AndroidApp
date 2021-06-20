package com.example.myapplication.api.user.serivce

import android.util.Log
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.user.controller.UserProfileInterface
import com.example.myapplication.api.user.model.UserModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class ProfileUserService {

    fun UserProfile(){
        val call : Call<UserModel> = ApiClient.buildService(UserProfileInterface::class.java).getUserInformation()

        call.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val userInfo = response.body()
                if(userInfo!=null){
                    Log.d("User","my user profile")
                }

            }
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                error("Ko")
            }
        })

    }

}