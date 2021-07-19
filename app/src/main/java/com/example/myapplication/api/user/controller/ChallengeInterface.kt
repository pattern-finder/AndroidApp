package com.example.myapplication.api.user.controller

import com.example.myapplication.api.user.model.ChallengeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChallengeInterface {

    @Headers("Content-Type: application/json")
    @GET("/challenges")
    fun getChallenges() : Call<ChallengeModel>

}