package com.hakanbaysal20.logincontrolwithsharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hakanbaysal20.logincontrolwithsharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val username = sp.getString("username","fail")
        val password = sp.getString("password","fail")
        if (username == "admin" && password == "123"){
            startActivity(Intent(this@MainActivity,Home::class.java))
            finish()
        }

        val edit = sp.edit()

        binding.buttonLogin.setOnClickListener {
            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()
            if (username == "admin" && password == "123"){

                val intent = Intent(this@MainActivity,Home::class.java)
                edit.putBoolean("IsLogin",true)
                edit.putString("username",username)
                edit.putString("password",password)
                edit.commit()
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(applicationContext,"Kullanıcı adı veya şifre hatalı",Toast.LENGTH_SHORT).show()
            }


        }
    }

}
