package com.example.trainersapp.model

import com.example.trainersapp.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Home : NavigationItem("home", R.drawable.home_icon, "Home")
    object Search :NavigationItem("search", R.drawable.search_icon, "Search")
    object Favourites :NavigationItem("favourites", R.drawable.heart_icon, "Favourites")
    object Notification :NavigationItem("notifications", R.drawable.bell_icon, "Notifications")
}
