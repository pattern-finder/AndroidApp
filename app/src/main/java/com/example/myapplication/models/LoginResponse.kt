package com.example.myapplication.models

data class LoginResponse(val error:Boolean, val message:String, val user: User)