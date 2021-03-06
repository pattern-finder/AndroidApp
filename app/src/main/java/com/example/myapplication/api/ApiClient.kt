package com.example.myapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL: String = "https://picspy-api.herokuapp.com/"
    private var retrofit: Retrofit? = null
    private var httpClient = OkHttpClient.Builder()
    private var mRetrofit: Retrofit? = null

    fun <T> buildService(service: Class<T>): T {
        this.retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

        return retrofit?.create(service)!!
    }



}
