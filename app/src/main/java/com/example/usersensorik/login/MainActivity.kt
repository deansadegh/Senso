package com.example.usersensorik.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
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
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment ||
                destination.id == R.id.splashFragment||
                destination.id==R.id.forgotpassFragment||
                destination.id==R.id.chengepasswordFragment

                    ) {
                binding.bottomNavigationView.visibility = View.GONE
                binding.questionnaires.visibility=View.GONE
            } else {
                binding.questionnaires.visibility=View.VISIBLE
                binding.bottomNavigationView.visibility = View.VISIBLE
            }

        }
        binding.questionnaires.setOnClickListener {
            binding.bottomNavigationView.selectedItemId = R.id.homeFragment
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id == R.id.loginFragment||
            navController.currentDestination?.id == R.id.homeFragment||
            navController.currentDestination?.id == R.id.profileFragment ||
           navController.currentDestination?.id == R.id.chengepasswordFragment||
            navController.currentDestination?.id == R.id.tabFragment
        )
            finish()
        super.onBackPressed()
    }

}