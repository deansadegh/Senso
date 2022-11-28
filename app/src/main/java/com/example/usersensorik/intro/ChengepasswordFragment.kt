package com.example.usersensorik.intro

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.usersensorik.R
import com.example.usersensorik.databinding.FragmentChengepasswordBinding
import com.example.usersensorik.login.Loginviewmodel

class ChengepasswordFragment : Fragment() {
    lateinit var binding: FragmentChengepasswordBinding
    lateinit var viewModel: Loginviewmodel
    lateinit var shared: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChengepasswordBinding.inflate(inflater, container, false)
        shared = requireContext().getSharedPreferences("Test", Context.MODE_PRIVATE)

        viewModel = ViewModelProvider(requireActivity())[Loginviewmodel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
        binding.newpAssword.doOnTextChanged { text, start, before, count ->
            viewModel.regxNewPassword(text.toString())

        }
        binding.confirmNewPassword.doOnTextChanged { text, start, before, count ->
            if (text.toString() == binding.newpAssword.text.toString()) {
                binding.setTextError.visibility = View.INVISIBLE
            } else {
                binding.setTextError.visibility = View.VISIBLE
                binding.save.isEnabled = true
            }


        }
        binding.cancelBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.save.setOnClickListener {

            viewModel.changePassword(binding.confirmNewPassword.text.toString())
}
    }

    private fun subscribe() {
        viewModel.passwordNubmber.observe(viewLifecycleOwner) {
            binding.checkNumber.setImageResource(
                if (it)
                    R.drawable.ic_active_checkbox
                else
                    R.drawable.ic_passive_checkbox
            )

        }
        viewModel.passwordUpperCase.observe(viewLifecycleOwner) {
            binding.checkUppercase.setImageResource(
                if (it)
                    R.drawable.ic_active_checkbox
                else
                    R.drawable.ic_passive_checkbox
            )

        }
        viewModel.passwordLength.observe(viewLifecycleOwner) {
            binding.checkCharacters.setImageResource(
                if (it)
                    R.drawable.ic_active_checkbox
                else
                    R.drawable.ic_passive_checkbox
            )

        }
    }
}