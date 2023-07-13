package com.example.trainersapp.navigation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

data class TabItem(
    val title: String,
    @DrawableRes val logo: Int,
    val screen: @Composable () -> Unit
)
