package com.hakanbaysal20.navigationcomponentkullanimi.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hakanbaysal20.navigationcomponentkullanimi.R
import com.hakanbaysal20.navigationcomponentkullanimi.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navigationView,navHost.navController)

        binding.toolbar.title = "Telli"
        val toggle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        toggle.syncState()
        val title = binding.navigationView.inflateHeaderView(R.layout.nav_drawer_title)
        var textViewTitle = title.findViewById(R.id.textViewLan) as TextView
        textViewTitle.text = "Türkiye"



    }
}