package com.example.myapplication.api.user.controller.service

import android.util.Log
import com.example.myapplication.api.provider.ApiClient
import com.example.myapplication.api.user.controller.AuthentificationInterface
import com.example.myapplication.api.user.controller.model.LoginModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationService {
    fun login(loginData: LoginModel, onResult: (JsonObject?) -> Unit) {
        val call: Call<JsonObject> = ApiClient.buildService(AuthentificationInterface::class.java).login(loginData)

        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                Log.d("Login", "Success ${response?.body().toString()}")
                onResult(response?.body())
            }
            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                Log.d("Login", "Failure ${call?.request()}")
                onResult(null)
            }
        })
    }

    fun testCo(onResult: (JsonObject?) -> Unit) {
        val call: Call<JsonObject> = ApiClient.buildService(AuthentificationInterface::class.java).testCo()

        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                Log.d("Login", "Success ${response?.body().toString()}")
                onResult(response?.body())
            }
            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                Log.d("Login", "Failure ${call?.request()}")
                onResult(null)
            }
        })
    }
}
