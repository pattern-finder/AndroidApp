package com.example.myapplication.api.user.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ChallengeModel(
    @SerializedName("content")
    val content: List<Content?>?,
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
        val execBootstraps: List<ExecBootstrap?>?,
        @SerializedName("_id")
        val id: String?,
        @SerializedName("instructions")
        val instructions: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("owner")
        val owner: String?,
        @SerializedName("url")
        val url: String?
    ) {
        @Keep
        data class ExecBootstrap(
            @SerializedName("challenge")
            val challenge: String?,
            @SerializedName("functionTemplate")
            val functionTemplate: String?,
            @SerializedName("_id")
            val id: String?,
            @SerializedName("language")
            val language: String?,
            @SerializedName("tests")
            val tests: String?,
            @SerializedName("__v")
            val v: Int?
        )
    }
}