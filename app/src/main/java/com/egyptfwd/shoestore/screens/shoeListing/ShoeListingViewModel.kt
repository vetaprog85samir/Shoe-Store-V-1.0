package com.egyptfwd.shoestore.screens.shoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.egyptfwd.shoestore.models.ShoeModel

class ShoeListingViewModel : ViewModel() {

    private var shoeList = mutableListOf<ShoeModel>()

    private val _shoeModel = MutableLiveData<List<ShoeModel>>()
    val shoeModel: LiveData<List<ShoeModel>> get() = _shoeModel


    fun saveShoeDetails(
        name:String,
        size:Double,
        company:String,
        description:String
    ){

        shoeList.add(ShoeModel(name, size, company, description))
        _shoeModel.value = shoeList

    }

}