package com.example.trainersapp.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun VisaPaymentDetails(navController: NavController) {
    val textState = rememberSaveable { mutableStateOf("") }
    val textState1 = rememberSaveable { mutableStateOf("") }
    val textState2 = rememberSaveable { mutableStateOf("") }
    val textState3 = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .heightIn(119.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    {
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .heightIn(43.dp)
                    .fillMaxWidth(),
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
                        navController.navigate("pay_select") {
                            popUpTo("pay_select") { inclusive = true }
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
            Spacer(modifier = Modifier.heightIn(8.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .heightIn(220.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(painter = painterResource(id = R.drawable.visa_card_template),
                    contentDescription = "visa card")
            }

        }

        Spacer(modifier = Modifier.heightIn(16.dp))


        Text(
            text = "Cardholder name:",
            modifier = Modifier.fillMaxWidth(),
            style = PoppinsTypography.body1,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
        )
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),

            )

        Spacer(modifier = Modifier.heightIn(16.dp))

        Text(
            text = "Card number:",
            modifier = Modifier.fillMaxWidth(),
            style = PoppinsTypography.body1,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
        )
        OutlinedTextField(
            value = textState1.value,
            onValueChange = { textState1.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),
            trailingIcon = {
                Icon(

                    painter = painterResource(id = R.drawable.visa_tiny),
                    "",
                    tint = Color.Unspecified,
                )
            }

        )

        Spacer(modifier = Modifier.heightIn(24.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = textState2.value,
                placeholder = {
                    Text(
                        "Expiry date:  MM/YY",
                        style = PoppinsTypography.body1,
                        fontSize = 16.sp,
                    )
                },
                onValueChange = { textState2.value = it },
                modifier = Modifier
                    .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                    .widthIn(min = 192.dp)
                    .heightIn(min = 60.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(App_purple_fade),
            )


            OutlinedTextField(
                value = textState3.value,
                placeholder = {
                    Text(
                        "CVV:",
                        style = PoppinsTypography.body1,
                        fontSize = 16.sp,
                    )
                },
                onValueChange = { textState3.value = it },
                modifier = Modifier
                    .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                    .widthIn(min = 137.dp)
                    .heightIn(min = 60.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(App_purple_fade),
            )

        }

        Spacer(modifier = Modifier.heightIn(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
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

        Spacer(modifier = Modifier.heightIn(58.dp))

        Column()
        {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = (ButtonDefaults.buttonColors(App_purple)),
                onClick = { /*TODO*/ })
            {
                Text(
                    text = "Pay now",
                    style = PoppinsTypography.button,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
        }


    }
}


@Composable
fun VisaPaymentScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
        VisaPaymentDetails(navController)
    }

}


@Preview(showBackground = true)
@Composable
fun VisaPaymentScreenPreview() {
    val navController = rememberNavController()
    VisaPaymentScreen(navController)
}
