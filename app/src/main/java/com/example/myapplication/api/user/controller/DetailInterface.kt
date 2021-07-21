package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.model.DetailModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface DetailInterface {
    //@Headers("Content-Type: application/json")
    //@GET("/challenges/60db58ea7613a9f1a1368bd8")
    //fun getDetailChallenge() : Call<DetailModel>
    @Headers("Content-Type: application/json")
    @GET("/challenges/{id}")
     fun getDetailChallenge( @Path("id") id: String): Call<DetailModel>

}