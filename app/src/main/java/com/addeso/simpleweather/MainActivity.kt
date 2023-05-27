package com.addeso.simpleweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.navigation)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController

        navView.setupWithNavController(navController)


        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_weather -> {
                    navController.navigate(R.id.weatherFragment)
                    true
                }
                R.id.navigation_city -> {
                    navController.navigate(R.id.cityFragment)
                    true
                }
                else -> false
            }
        }
    }
}