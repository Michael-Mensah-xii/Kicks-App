package com.example.trainersapp.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun PaymentSelect(
    @DrawableRes drawable: Int,
    onClick: (() -> Unit)?,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(101.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(App_purple_fade)
            .clickable {
                onClick?.invoke()
            },
    ) {
        Row(
            modifier = Modifier
                .heightIn(69.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = drawable),
                contentDescription = "temp",
            )

        }

    }
}

@Composable
fun PaymentList(
    navController: NavController,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChoosePayment(navController)
        Text(
            text = "Choose your payment method",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 32.dp),
            style = PoppinsTypography.body1,
            fontSize = 16.sp,
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .weight(50f)
                .heightIn(303.dp)
                .padding(vertical = 16.dp),
            content = {
                items(paymentData) { item ->
                    PaymentSelect(
                        drawable = item.drawable,
                        onClick = {
                            if (item.drawable == R.drawable.visa) {
                                navController.navigate("visa_select") {
                                    popUpTo("visa_select") { inclusive = true }
                                }
                            } else if (item.drawable == R.drawable.mastercard) {
                                navController.navigate("mastercard_select") {
                                    popUpTo("mastercard_select") { inclusive = true }
                                }
                            } else {
                                null
                            }
                        }
                    )
                }
            }
        )

        Spacer(modifier = Modifier.heightIn(48.dp))

    }

}

data class PaymentElementData(
    val drawable: Int,
)

val paymentData = listOf(
    PaymentElementData(R.drawable.visa),
    PaymentElementData(R.drawable.mastercard),
    PaymentElementData(R.drawable.paypal),
)


@Composable
fun ChoosePayment(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(32.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .heightIn(43.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(App_purple_fade)
                    .padding(4.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    navController.navigate("cart") {
                        popUpTo("cart") { inclusive = true }
                    }
                }) {
                    Icon(
                        modifier =
                        Modifier
                            .size(20.dp, 20.dp),
                        painter = painterResource(id = R.drawable.backpressed),
                        contentDescription = null,
                        tint = App_purple
                    )
                }

            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Choose Payment",
                style = PoppinsTypography.h1,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 62.dp)
            )
        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .padding(horizontal = 16.dp)
                .heightIn(45.dp)
                .background(App_purple_fade),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Total price:",
                style = PoppinsTypography.h1,
                fontSize = 16.sp,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "GHS 1200.00",
                fontSize = 14.sp,
                color = Color.Black,
            )

        }

    }


}


@Preview(showBackground = true)
@Composable
fun ChoosePaymentPreview() {
    val navController = rememberNavController()
    ChoosePayment(navController)
}

@Preview(showBackground = true)
@Composable
fun PaymentListPreview() {
    val navController = rememberNavController()
    PaymentList(navController)
}

