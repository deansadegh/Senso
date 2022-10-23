package com.example.usersensorik.intro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var shared: SharedPreferences
 lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shared =requireContext().getSharedPreferences("Test" , Context.MODE_PRIVATE)
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.exitBtn.setOnClickListener {

            findNavController().navigate(R.id.loginFragment)
        }
        binding.Chengepasswordbtn.setOnClickListener{
            findNavController().navigate(R.id.chengepasswordFragment)
            val edit = shared.edit()
            edit.putBoolean("login",false )
            edit.apply()
        }

        return binding.root
    }


}