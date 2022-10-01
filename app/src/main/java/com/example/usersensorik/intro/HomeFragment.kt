package com.example.usersensorik.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // getting the recyclerview by its id


        // this creates a vertical layout Manager


        // ArrayList of class ItemsViewModel
        val data = ArrayList<listmodel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click","فرگمنت چیست؟ چگونه یک فرگمنت اندروید بسازیم؟"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click","رویکرد جدید؛ یک اکتیویتی برای هر اپلیکیشن کافیه! "))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","معماری ها در اندروید"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","گیت چیست و چگونه از آن استفاده کنیم؟"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","درامد در چهار روز"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","گیت چیست و چگونه از آن استفاده کنیم؟"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","گیت چیست و چگونه از آن استفاده کنیم؟"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click ","گیت چیست و چگونه از آن استفاده کنیم؟"))


        // This will pass the ArrayList to our Adapter
        val adapter = castomAdapter(data)

        // Setting the Adapter with the recyclerview
        binding.recyclerHome.adapter = adapter
        return binding.root    }


}