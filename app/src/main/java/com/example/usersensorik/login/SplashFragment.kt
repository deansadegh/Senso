package com.example.usersensorik.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay

class SplashFragment : Fragment() {
    lateinit var shared:SharedPreferences
lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shared = requireContext().getSharedPreferences("Test" , Context.MODE_PRIVATE)

        splash()
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }
    fun splash() {

        lifecycleScope.launchWhenCreated {
            delay(1000)
            if ( shared.getBoolean("login" , false ))
                findNavController().navigate(R.id.homeFragment)
            else
                findNavController().navigate(R.id.homeFragment)
        }
    }

}