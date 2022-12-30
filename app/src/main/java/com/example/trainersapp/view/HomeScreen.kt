package com.example.trainersapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.trainersapp.ui.theme.RatingYellow






//create rating system
@Composable
fun Rating(
    rating: Int, modifier: Modifier = Modifier,
) {
    Row(modifier.padding(horizontal = 0.dp)
    ) {
        for (i in 1..5) {
            if (i <= rating) {
                Icon(
                    painter = painterResource(id = com.example.trainersapp.R.drawable.ic_star),
                    tint = RatingYellow,
                    contentDescription = null,
                )
            } else {
                Icon(
                    painter = painterResource(id = com.example.trainersapp.R.drawable.ic_star_empty),
                    contentDescription = null,
                )
            }
        }
    }
}