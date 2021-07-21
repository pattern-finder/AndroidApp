package com.example.myapplication.api.user.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DetailModel(
    @SerializedName("content")
    val content: Content?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("statusCode")
    val statusCode: Int?
) {
    @Keep
    data class Content(
        @SerializedName("createdAt")
        val createdAt: String?,
        @SerializedName("editedAt")
        val editedAt: String?,
        @SerializedName("execBootstraps")
        val execBootstraps: List<Any?>?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("instructions")
        val instructions: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("owner")
        val owner: String?,
        @SerializedName("pictures")
        val pictures: List<Picture?>?,
        @SerializedName("url")
        val url: String?
    ) {
        @Keep
        data class Picture(
            @SerializedName("file")
            val `file`: String?,
            @SerializedName("_id")
            val id: String?
        )
    }
}