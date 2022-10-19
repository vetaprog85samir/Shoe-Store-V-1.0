package com.egyptfwd.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoeModel(

    //initializing variables
    var name: String = "",
    var size: Double? = null,
    var company: String = "",
    var description: String = "",
    val images: List<String> = mutableListOf()

) : Parcelable