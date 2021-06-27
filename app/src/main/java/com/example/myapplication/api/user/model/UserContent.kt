package com.example.myapplication.api.user.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class UserContent(
    @SerializedName("content")
    val content: List<Content?>?
) {
    @Keep
    data class Content(
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("username")
        val username: String?
    )
}