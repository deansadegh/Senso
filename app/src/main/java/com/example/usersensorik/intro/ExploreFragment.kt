package com.example.usersensorik.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.usersensorik.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ExploreFragment : Fragment() {
    lateinit var binding: FragmentExploreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titles = listOf("Home","chat","Setting")
        binding.viewPager.adapter = activity?.let { Adaptor(it) }
        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()
    }

}