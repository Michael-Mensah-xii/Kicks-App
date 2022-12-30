package com.example.trainersapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ShoeData(
    @DrawableRes val id: Int,
    @StringRes val name: Int,
    val rating: Int,
    @StringRes val price: Int,
    @StringRes val description: Int,
)
