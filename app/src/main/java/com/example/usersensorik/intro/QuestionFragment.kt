package com.example.usersensorik.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        // getting the recyclerview by its id


        // this creates a vertical layout Manager


        // ArrayList of class ItemsViewModel
        val data = ArrayList<listmodel>()

        // This loop will create 20 Views containing
        // the image with the count of view

        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click","فرگمنت چیست؟ چگونه یک فرگمنت اندروید بسازیم؟"))
        data.add(listmodel(R.drawable.ic_baseline_folder_24, "Click","رویکرد جدید؛ یک اکتیویتی برای هر اپلیکیشن کافیه! "))




        // This will pass the ArrayList to our Adapter
        val adapter = castomAdapter(data){
            val bundle = Bundle()
            bundle.putSerializable(TRANSFER, data[it])
            findNavController().popBackStack()
            findNavController().navigate(R.id.tabFragment,bundle)


           // Toast.makeText(requireContext(), "selected  $it", Toast.LENGTH_SHORT).show()
        }
        // Setting the Adapter with the recyclerview
        binding.recyclerHome2.adapter = adapter
        return binding.root
    }


companion object{
  const  val TRANSFER = "TRANSFER"
}
}
