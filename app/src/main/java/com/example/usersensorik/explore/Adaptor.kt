package com.example.usersensorik.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.usersensorik.explore.ChatFragment
import com.example.usersensorik.explore.ExplorehomeFragment
import com.example.usersensorik.explore.SettingFragment

class Adaptor
    (fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> ExplorehomeFragment()
            1 -> ChatFragment()
            else -> SettingFragment()

        }
    }
}
