package com.example.usersensorik.intro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.usersensorik.explore.SettingFragment

class ViewPagerFragmentAdapterQuestionList(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> Question2Fragment()
            1 -> QuestionFragment()
            else -> SettingFragment()
        }
    }


    override fun getItemCount(): Int {
        return 2
    }
}