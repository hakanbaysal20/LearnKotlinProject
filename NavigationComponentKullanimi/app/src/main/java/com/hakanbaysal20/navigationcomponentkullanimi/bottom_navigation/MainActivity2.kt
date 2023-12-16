package com.hakanbaysal20.navigationcomponentkullanimi.bottom_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.hakanbaysal20.navigationcomponentkullanimi.R
import com.hakanbaysal20.navigationcomponentkullanimi.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNav,navHostFragment.navController)
        NavigationUI.setupWithNavController(binding.navigationView,navHostFragment.navController)
        binding.mainToolBar.title = "Başlık"
        val toggle = ActionBarDrawerToggle(this,binding.drawer,binding.mainToolBar,0,0)
        binding.drawer.addDrawerListener(toggle)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white)
        toggle.syncState()
        val title = binding.navigationView.inflateHeaderView(R.layout.navigation_drawer_title)
        var textViewTitle = title.findViewById(R.id.textViewTitle) as TextView
        textViewTitle.text = "Merhaba"

    }
    override fun onBackPressed() {
        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
            }else{
                onBackPressedDispatcher.onBackPressed()
            }
    }
}