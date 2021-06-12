package com.example.myapplication.api.user.model

import java.time.LocalDate
import java.util.*

data class UserModel(
        val username:String,
        val password:String,
        val email:String,
        val avatarUrl:String,
        val editedAt:Date,
        val createdAt:Date,
        val deletedAt:Date
)