package com.abhinav.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        val tvCreateAccount = findViewById<TextView>(R.id.tvCreateAccount)
        tvCreateAccount.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)


            startActivity(intent)
            finish()
        }
    }


}