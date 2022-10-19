package com.egyptfwd.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.egyptfwd.shoestore.R
import com.egyptfwd.shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //using view binding
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater, R.layout.fragment_instructions, container, false
        )

        binding.fragmentInstructionsBtn.setOnClickListener { view : View ->

            //using navigation
            view.findNavController()
                .navigate(R.id.action_instructionsFragment_to_shoeListingFragment)
        }

        return binding.root
    }


}