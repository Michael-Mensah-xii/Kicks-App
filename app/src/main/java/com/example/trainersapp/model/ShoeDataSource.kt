package com.example.trainersapp.model

import com.example.trainersapp.R

class ShoeDataSource {

    fun loadData(): List<ShoeData> {
        return listOf(
            ShoeData(R.drawable.yellow_adidas,
                R.string.yellow_adidas_string,
                3,
                200.50,
                R.string.generic_review),

            ShoeData(R.drawable.red_adidas,
                R.string.red_adidas_string,
                4,
                189.99,
                R.string.generic_review),

            ShoeData(R.drawable.white_adidas,
                R.string.white_adidas_string,
                4,
                300.00,
                R.string.generic_review),

            ShoeData(R.drawable.ash_adidas,
                R.string.ash_adidas_string,
                3,
                200.00,
                R.string.generic_review),

            ShoeData(R.drawable.blue_adidas,
                R.string.blue_adidas_string,
                4,
                250.00,
                R.string.generic_review),

            ShoeData(R.drawable.pink_adidas,
                R.string.pink_adidas_string,
                3,
                200.00,
                R.string.generic_review)
        )
    }
}


