package com.egyptfwd.shoestore.utils

import androidx.databinding.InverseMethod

object DoubleConverter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double?): String? {

        if (value == null) {
            return null
        }
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String?): Double? {

        if (value == null) {
            return null
        }

        return value.toDouble()
    }

}