package com.example.usersensorik.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.usersensorik.databinding.FragmentTabBinding


class TabFragment : Fragment() {
lateinit var binding: FragmentTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding=FragmentTabBinding.inflate(inflater,container,false)

        //upload photo with glide
        val url="https://www.tutorialspoint.com/images/tp-logo-diamond.png"
        Glide.with(requireContext()).load(url)
            .into(binding.view)
        return binding.root
    }

}

