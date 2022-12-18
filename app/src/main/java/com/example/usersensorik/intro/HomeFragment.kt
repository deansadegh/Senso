package com.example.usersensorik.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initTabLayout()
        return binding.root    }

    private fun initTabLayout() {
        val titles = resources.getStringArray(R.array.title)
        binding.viewPager.adapter = activity?.let { ViewPagerFragmentAdapterQuestionList(it) }
        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        { tab: TabLayout.Tab, position: Int ->
            tab.text = titles[position]
        }.attach()

        binding.viewPager.isSaveEnabled = true
        binding.viewPager.post {

            binding.viewPager.setCurrentItem(1, false)
            binding.tabLayout.getTabAt(1)?.let { tab -> setTabBackground(tab) }
            //binding.viewPager.setCurrentItem(0, true)
        }
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    setTabBackground(it)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

                tab?.view?.background =
                    ContextCompat.getDrawable(requireContext(), R.color.transparent)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }


    private fun setTabBackground(tab: TabLayout.Tab) {
        if (tab.position == 1) {
            tab.view.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.tab_background_selected_yellow
            )
            binding.tabLayout.setTabTextColors(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.gray_4
                ),
                ContextCompat.getColor(requireContext(), R.color.colorPrimary)
            )
        } else {
            binding.tabLayout.setTabTextColors(
                ContextCompat.getColor(requireContext(), R.color.gray_4),
                ContextCompat.getColor(requireContext(), R.color.white)
            )
            tab.view.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.tab_background_selected
            )
        }
    }
}

