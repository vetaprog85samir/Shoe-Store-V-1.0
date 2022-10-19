package com.egyptfwd.shoestore.screens.shoeListing

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.egyptfwd.shoestore.R
import com.egyptfwd.shoestore.databinding.FragmentShoeListingBinding
import com.egyptfwd.shoestore.databinding.RowItemAddShoeBinding
import com.egyptfwd.shoestore.screens.login.LoginFragment

class ShoeListingFragment : Fragment(), MenuProvider {

    //creating shared viewModel
    private val shoeListingViewModel : ShoeListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //using view binding
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(
            inflater, R.layout.fragment_shoe_listing, container, false
        )


        //observing shoeModel liveData
        shoeListingViewModel.shoeModel.observe(viewLifecycleOwner) { shoeModelListItem ->

            //inflating, setting and adding row_item_add_shoe to fragment_shoe_listing_ll
            shoeModelListItem?.forEach {
                val rowItemAddShoe = RowItemAddShoeBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.fragmentShoeListingLl, false
                )
                with(rowItemAddShoe) {
                    rowItemAddShoeTvShoeName.text = "Name: " + it.name
                    rowItemAddShoeTvShoeSize.text = "Size: " + it.size.toString()
                    rowItemAddShoeTvCompanyName.text = "Company: " + it.company
                    rowItemAddShoeTvShoeDescription.text = "Description: " + it.description
                }
                binding.fragmentShoeListingLl.addView(rowItemAddShoe.root)
            }
        }

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        //setting & showing up toolbar menu
        val menuHost : MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner)

        binding.fragmentShoeListingFloatingBtn.setOnClickListener{view:View ->

            //navigation
            view.findNavController()
                .navigate(ShoeListingFragmentDirections
                    .actionShoeListingFragmentToShoeDetailFragment())
        }
        return binding.root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shoe_listing_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

        //navigation to LoginFragment
        val navController = findNavController()
        if (menuItem.itemId == R.id.loginFragment){
            navController.navigate(R.id.loginFragment)
        }
        return true
        
//        return NavigationUI.onNavDestinationSelected(
//            menuItem, requireView().findNavController())

    }
}








