package com.example.usersensorik.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentExploreHomeBinding
import com.example.usersensorik.databinding.FragmentQuestion2Binding
import com.example.usersensorik.intro.castomAdapter
import com.example.usersensorik.intro.listmodel

class Question2Fragment : Fragment() {
    lateinit var binding: FragmentQuestion2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestion2Binding.inflate(inflater, container, false)
        // getting the recyclerview by its id


        // this creates a vertical layout Manager


        // ArrayList of class ItemsViewModel
        val data = ArrayList<listmodel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click", "Hello sexsy"))


        // This will pass the ArrayList to our Adapter
        val adapter = castomAdapter(data){
            Toast.makeText(requireContext(), "selcted  $it", Toast.LENGTH_SHORT).show()
        }

        // Setting the Adapter with the recyclerview
        binding.recyclerHome2.adapter = adapter
        return binding.root

    }
}



