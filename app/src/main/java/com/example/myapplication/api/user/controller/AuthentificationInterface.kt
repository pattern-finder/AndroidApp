package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.controller.model.LoginModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthentificationInterface {
    @Headers("Content-Type: application/json")
    @POST("/login")
    fun login(@Body loginData: LoginModel): Call<JsonObject>

    @Headers("Content-Type: application/json")
    @GET("todos/1")
    fun testCo(): Call<JsonObject>
}