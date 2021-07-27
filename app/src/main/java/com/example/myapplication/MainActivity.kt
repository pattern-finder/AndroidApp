package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.api.user.model.LoginModel
import com.example.myapplication.api.user.serivce.AuthenticationService
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user_name = findViewById<EditText>(R.id.et_user_name)
        var password = findViewById<EditText>(R.id.et_password)
        var btn_submit = findViewById<Button>(R.id.btn_submit)


        btn_submit.setOnClickListener{
        //    Toast.makeText(this,"Button is clicked", Toast.LENGTH_LONG).show();
            login(user_name,password)
        }
    }
    private fun login(usernameInput: EditText, passwordInput: EditText) {

        val username = usernameInput.text.toString()
        val password = passwordInput.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()
                && username.isNotBlank() && password.isNotBlank()) {

            val loginService = AuthenticationService()
            var response: JsonObject?

            loginService.login(LoginModel(username, password)) { loginResponse ->
                response = loginResponse
                if (response !== null) {

                    val intent = Intent(this,Profile::class.java)
                    intent.putExtra("username",username)
                    startActivity(intent)
                    Toast.makeText(this,"Connexion Réussie", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(
                            applicationContext,
                            "Login Failed ! ",
                            Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}