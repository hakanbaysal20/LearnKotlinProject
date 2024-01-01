package com.hakanbaysal20.logincontrolwithsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanbaysal20.logincontrolwithsharedpreferences.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val edit = sp.edit()
        var username = sp.getString("username","fail")
        var password = sp.getString("password","fail")
        binding.textViewUsername.text = "Username : $username"
        binding.textViewPassword.text = "Password : $password"
        binding.buttonSignOut.setOnClickListener {
            edit.remove("username")
            edit.remove("password")
            edit.commit()
            startActivity(Intent(this@Home,MainActivity::class.java))
            finish()
        }
    }
}