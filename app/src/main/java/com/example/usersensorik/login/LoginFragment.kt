package com.example.usersensorik.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var shared: SharedPreferences
    lateinit var viewModel: Loginviewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shared = requireContext().getSharedPreferences("Test", Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(requireActivity())[Loginviewmodel::class.java]
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subsciber()
        binding.loginUser.doOnTextChanged { text, _, _, _ ->
            viewModel.checkUserName(text.toString())
        }
        binding.passwordUser.doOnTextChanged { text, _, _, _ ->
            viewModel.checkPassword(text.toString())

        }
        binding.loginBtn.setOnClickListener {

            viewModel.loginUser(binding.loginUser.text.toString(),binding.passwordUser.text.toString())

        }
        binding.forgot.setOnClickListener {
            findNavController().navigate(R.id.forgotpassFragment)
        }
    }
    private fun subsciber() {
        viewModel.userNameLiveDataMessage.observe(viewLifecycleOwner) { message ->
            binding.loginUserBtn.error = message

        }
        viewModel.passwordLiveData.observe(viewLifecycleOwner) { message ->
            if (message!="")
            binding.passwordUser.error = message
        }
        viewModel.loginUser.observe(viewLifecycleOwner) {
            if (it == "") {
                val edit = shared.edit()
                edit.putBoolean("login", true)
                findNavController().navigate(R.id.profileFragment)
                edit.apply()
            }else{
                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
            }

        }
    }

}
