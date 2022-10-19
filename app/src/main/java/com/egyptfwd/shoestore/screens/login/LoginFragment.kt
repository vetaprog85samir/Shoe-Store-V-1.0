package com.egyptfwd.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.egyptfwd.shoestore.R
import com.egyptfwd.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //using view binding
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )

        binding.fragmentLoginLoginBtn.setOnClickListener { view: View ->

            //using navigation
            view.findNavController()
                .navigate(LoginFragmentDirections
                    .actionLoginFragmentToWelcomeFragment())
            // Hide the keyboard.
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        binding.fragmentLoginRegisterBtn.setOnClickListener { view : View ->

            //using navigation
            view.findNavController()
                .navigate(LoginFragmentDirections
                    .actionLoginFragmentToWelcomeFragment())
            // Hide the keyboard.
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        return binding.root
    }
}