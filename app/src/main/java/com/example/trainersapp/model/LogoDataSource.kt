package com.example.trainersapp.model

import com.example.trainersapp.R

    class LogoDataSource{
    fun loadData():List<LogoData>{
        return listOf(
            LogoData(R.drawable.nike_logo),
            LogoData(R.drawable.puma_logo),
            LogoData(R.drawable.adidas_logo),
            LogoData(R.drawable.vans_logo)
        )
    }
}




