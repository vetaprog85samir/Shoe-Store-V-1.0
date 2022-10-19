package com.egyptfwd.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.egyptfwd.shoestore.R
import com.egyptfwd.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //using view binding
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container, false
        )

        binding.fragmentWelcomeBtn.setOnClickListener { view:View ->

            //using navigation
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }

        return binding.root
    }
}