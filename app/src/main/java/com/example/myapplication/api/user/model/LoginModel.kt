package com.example.myapplication.api.user.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginModel (
        @Expose
        @SerializedName("username")
        val username: String,
        @Expose
        @SerializedName("password")
        val password: String
)