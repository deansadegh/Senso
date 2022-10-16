package com.example.usersensorik.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentForgotpassBinding


class ForgotpassFragment : Fragment() {
    lateinit var binding: FragmentForgotpassBinding
    lateinit var viewModel: Forgotpassviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotpassBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[Forgotpassviewmodel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subsciber()
        binding.emailInput.doOnTextChanged { text, _, _, _ ->
            Log.e("Forget",text.toString()+"forgot")
            viewModel.checkforget(text.toString())

        }

        binding.backlogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.forgot.setOnClickListener {

            viewModel.loginforget(binding.emailInput.text.toString())

        }
    }

    private fun subsciber() {
        viewModel.forgotNameLiveDataMessage.observe(viewLifecycleOwner) { message ->
            binding.loginUserBtn.error = message
            Log.e("Forget",message)

        }
    }

}
