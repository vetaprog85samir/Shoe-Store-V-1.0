package com.egyptfwd.shoestore.screens.shoeDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.egyptfwd.shoestore.R
import com.egyptfwd.shoestore.databinding.FragmentShoeDetailsBinding
import com.egyptfwd.shoestore.models.ShoeModel
import com.egyptfwd.shoestore.screens.shoeListing.ShoeListingViewModel

class ShoeDetailFragment : Fragment() {

    //creating shared viewModel
    private val shoeListingViewModel : ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //viewBinding
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false
        )

        //dataBinding layout to ShoeModel class
        binding.shoeModel = ShoeModel()

        binding.fragmentShoeDetailsSaveBtn.setOnClickListener { view : View ->

            //dataBinding
            val name = binding.shoeModel?.name.toString()
            val size = binding.shoeModel?.size!!.toDouble()
            val company = binding.shoeModel?.company.toString()
            val description = binding.shoeModel?.description.toString()

            if (
                name.isEmpty() || company.isEmpty() || description.isEmpty()
            ){
                Toast.makeText(context, "please fill the empty fields",
                Toast.LENGTH_LONG).show()
            }else{

                // Hide the keyboard.
                val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)

                //calling shared viewModel method for saving entered data
                shoeListingViewModel.saveShoeDetails(name, size, company,description)

                //navigation
                view.findNavController()
                    .navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
            }

        }

        binding.fragmentShoeDetailsCancelBtn.setOnClickListener { view : View ->

            //navigation
            view.findNavController()
                .navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }

        return binding.root
    }
}