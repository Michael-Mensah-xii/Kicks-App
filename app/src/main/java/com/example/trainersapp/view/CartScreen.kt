package com.example.trainersapp.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_alpha
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun TotalPrice(navController: NavController) {
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
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
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

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Cart",
                style = PoppinsTypography.h1,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 48.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 82.dp)
                .padding(horizontal = 16.dp)
                .heightIn(45.dp)
                .background(App_purple_fade),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(R.string.price_tag),
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


@Composable
fun CartElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes price: Int,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(101.dp)
        .padding(horizontal = 16.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(App_purple_fade)

    ) {
        Row(
            modifier = Modifier
                .heightIn(69.dp)
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Image(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(width = 109.dp, height = 69.dp),
                painter = painterResource(id = drawable),
                contentDescription = "temp",
            )
            Column(modifier = Modifier
                .heightIn(69.dp)
                .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = text),
                    style = PoppinsTypography.h1,
                    fontSize = 14.sp,
                    modifier = Modifier.paddingFromBaseline(
                        top = 12.dp, bottom = 2.dp
                    )
                )

                Text(
                    text = stringResource(id = price),
                    style = PoppinsTypography.body1,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.paddingFromBaseline(
                        top = 2.dp, bottom = 12.dp
                    )
                )
            }

            Column(
                modifier = Modifier
                    .heightIn(69.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                CartItemButton()
            }
        }

    }
}


data class CartElementData(
    val drawable: Int,
    val text: Int,
    val price: Int,
)

val cartData = listOf(
    CartElementData(R.drawable.ash_adidas, R.string.ash_adidas_string, R.string.temp_price),
    CartElementData(R.drawable.red_adidas, R.string.red_adidas_string, R.string.temp_price),
    CartElementData(R.drawable.pink_adidas, R.string.pink_adidas_string, R.string.temp_price),
    CartElementData(R.drawable.yellow_adidas, R.string.yellow_adidas_string, R.string.temp_price)
)


// plus & minus button
@Composable
fun CartItemButton() {
    Box(
        modifier = Modifier
            .height(20.dp)
            .widthIn(15.dp)
            .padding(horizontal = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(App_purple_alpha)
                    .alpha(0.5f)
                    .size(18.dp)
                    .padding(2.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier =
                    Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.minimize),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            Text(
                text = "1",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(App_purple_alpha)
                    .alpha(0.5f)
                    .size(18.dp)
                    .padding(2.dp)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.text_add_icon),
                    tint = Color.Black
                )
            }
        }
    }

}


//create a button that says confirm order
@Composable
fun ConfirmOrderButton(navController: NavController) {
    Column(modifier = Modifier
        .padding(bottom = 32.dp)
        .padding(horizontal = 16.dp)
    ) {
        Button(
            modifier = Modifier
                .heightIn(58.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            colors = (ButtonDefaults.buttonColors(App_purple)),
            onClick = {
                navController.navigate("pay_select") {
                    popUpTo("pay_select") { inclusive = true }
                }
            }
        ) {
            Text(
                stringResource(R.string.confirm_button),
                style = PoppinsTypography.button,
                color = Color.Black,
                fontSize = 18.sp,
            )
        }
    }

}

//Cart Column
@Composable
fun CartElementColumn(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        TotalPrice(navController)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .weight(50f)
                .heightIn(303.dp)
                .padding(vertical = 16.dp),
            content = {
                items(cartData) { item ->
                    CartElement(
                        drawable = item.drawable,
                        text = item.text,
                        price = item.price

                    )

                }

            }
        )
        Column(modifier = Modifier
            .padding(bottom = 32.dp)
            .padding(horizontal = 16.dp)
        ) {
            Button(
                modifier = Modifier
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = (ButtonDefaults.buttonColors(App_purple)),
                onClick = {
                    navController.navigate("pay_select") {
                        popUpTo("pay_select") { inclusive = true }
                    }
                }
            ) {
                Text(
                    stringResource(R.string.confirm_button),
                    style = PoppinsTypography.button,
                    color = Color.Black,
                    fontSize = 18.sp,
                )
            }
        }
    }
}


//Screen
@Composable
fun CartScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        CartElementColumn(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun TotalPricePreview() {
    val navController = rememberNavController()

    TotalPrice(navController)
}

@Preview(showBackground = true)
@Composable
fun CartElementPreview() {
    CartElement(drawable = R.drawable.ash_adidas,
        text = R.string.ash_adidas_string,
        price = R.string.temp_price)
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    val navController = rememberNavController()
    CartScreen(navController)
}
