package com.example.trainersapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ShoeData(
    @DrawableRes val id: Int,
    @StringRes val name: Int,
    val rating: Int,
    val price: Double,
    @StringRes val description: Int,
)




