package com.example.myapplication.api.user.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class test(
    @SerializedName("content")
    val content: List<Content?>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("statusCode")
    val statusCode: Int?
) {
    @Keep
    data class Content(
        @SerializedName("avatarUrl")
        val avatarUrl: String?,
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("username")
        val username: String?
    )
}