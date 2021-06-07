package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user_name = findViewById<EditText>(R.id.et_user_name)
        var password = findViewById<EditText>(R.id.et_password)
        var btn_reset = findViewById<Button>(R.id.btn_reset)
        var btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_reset.setOnClickListener{
            user_name.setText("")
            password.setText("")
        }

        btn_submit.setOnClickListener{
            Toast.makeText(this,"Button is clicked", Toast.LENGTH_LONG).show();
        }

        /*loginService.login(LoginModel(username, password)) { loginResponse ->
//                response = loginResponse
//                if (response !== null) {
//                    Toast.makeText(
//                        applicationContext,
//                        response.toString(),
//                        Toast.LENGTH_LONG
//                    ).show()
//                    AppPreferences.isLogin = true
//                    AppPreferences.token = response?.get("token").toString()
//                    AppPreferences._id = response?.get("uid").toString()
//                    userService.getUser { res ->
//                        if (res !== null) {
//                            AppPreferences.user = UserModel(
//                                res.get("_id").toString(),
//                                res.get("login").toString(),
//                                res.get("password").toString(),
//                                res.get("email").toString(),
//                                res.get("isAdmin").asBoolean,
//                                res.get("isStaff").asBoolean
//                            )
//                        }
//                    }
//                    this.startActivity(Intent(this, MainActivity::class.java))
//                } else {
//                    Toast.makeText(
//                        applicationContext,
//                        "Login Failed ! ",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }*/

    }
}