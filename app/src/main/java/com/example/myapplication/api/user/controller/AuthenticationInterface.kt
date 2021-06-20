package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.model.LoginModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationInterface {
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun login(@Body loginData: LoginModel): Call<JsonObject>

}