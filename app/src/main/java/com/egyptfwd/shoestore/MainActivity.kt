package com.egyptfwd.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.egyptfwd.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        //using view binding
//        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main)

        //Timber for logging
        Timber.plant(Timber.DebugTree())

        //setting toolbar:

        //navController
        val navController = this.findNavController(R.id.shoe_store_nav_host_fragment)

        //appBarConfiguration
//        appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.loginFragment,
            R.id.shoeListingFragment))

        binding.activityMainToolbar
            .setupWithNavController(navController, appBarConfiguration)

        //to show up toolbar up btn
        setSupportActionBar(binding.activityMainToolbar)

        //to let toolbar up btn working
        binding.activityMainToolbar.setNavigationOnClickListener {onBackPressed()}

        //to show up toolbar menu
        binding.activityMainToolbar.showOverflowMenu()
    }

//When using a Toolbar, Navigation automatically handles
// click events for the Navigation button, so you do not
// need to override onSupportNavigateUp().

}