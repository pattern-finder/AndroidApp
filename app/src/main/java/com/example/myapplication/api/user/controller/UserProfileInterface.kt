package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.model.UserModel
import retrofit2.Call
import retrofit2.http.GET


interface UserProfileInterface {

    @GET("users/60a91153076d48ec19c7c1b8")
    fun getUserInformation() : Call<UserModel>

}