package com.example.usersensorik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.ActivityMainBinding
import com.example.usersensorik.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment ||
                destination.id == R.id.splashFragment
            ) {
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.loginFragment||
            navController.currentDestination?.id == R.id.homeFragment
           // navController.currentDestination?.id == R.id.profile ||
           // navController.currentDestination?.id == R.id.persen
        )
            finish()
        super.onBackPressed()
    }

}