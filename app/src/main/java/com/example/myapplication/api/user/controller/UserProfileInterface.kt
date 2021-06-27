package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.model.UserContent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface UserProfileInterface {
    @Headers("Content-Type: application/json")
    @GET("/users")
    fun getUser(): Call<UserContent>

}