package com.example.trainersapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.debitcard_models.CreditCardViewModel
import com.example.trainersapp.debitcard_models.FieldType
import com.example.trainersapp.debitcard_models.InputTransformation
import com.example.trainersapp.debitcard_models.InputValidator
import com.example.trainersapp.debitcard_views.CreditCard
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun MastercardPaymentDetails(navController: NavController, viewModel: CreditCardViewModel) {

    val focusHolderNum = FocusRequester()
    val focusExpiration = FocusRequester()
    val focusCVV = FocusRequester()

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
                        navController.navigateUp()
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

        }

        CreditCard(
            number = viewModel.number,
            expiration = viewModel.expiration,
            holderName = viewModel.name,
            cvc = viewModel.cvc,
            flipped = viewModel.flipped,
            emptyChar = 'X',
            showSecurityCode = false
        )

        Spacer(modifier = Modifier.heightIn(16.dp))


        Text(
            text = "Cardholder name:",
            modifier = Modifier.fillMaxWidth(),
            style = PoppinsTypography.body1,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
        )
        CustomTextField(
            value = viewModel.name,
            onValueChange = {
                InputValidator.parseHolderName(it)?.let { name ->
                    viewModel.name = name
                }
            },
            nextFocus = focusHolderNum,

            modifier = Modifier
                .onFocusChanged { state ->
                    if (state.isFocused) viewModel.flipped = false
                }
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
        CustomTextField(
            value = viewModel.number,
            onValueChange = {
                viewModel.number =
                    if (viewModel.number.length >= 16) viewModel.number.substring(0..15) else it

                // When value is completed, request focus of next field
                if (viewModel.number.length >= 16) focusExpiration.requestFocus()

            },
            keyboardType = KeyboardType.Number,
            nextFocus = focusExpiration,

            modifier = Modifier
                .onFocusChanged { state ->
                    if (state.isFocused) viewModel.flipped = false
                }
                .focusRequester(focusHolderNum)
                .fillMaxWidth()
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),
            trailingIcon = {
                Icon(

                    painter = painterResource(id = R.drawable.mastercard_tiny),
                    "",
                    tint = Color.Unspecified,
                )
            }

        )

        Spacer(modifier = Modifier.heightIn(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextField(
                value = viewModel.expiration,
                visualTransformation = InputTransformation(FieldType.EXPIRATION),
                placeholder = "Expiry date:  MM/YY",
                onValueChange = {
                    viewModel.expiration = if (it.length >= 4) it.substring(0..3) else it

                    // When value is completed, request focus of next field
                    if (viewModel.expiration.length >= 4) focusCVV.requestFocus()
                },
                keyboardType = KeyboardType.Number,
                nextFocus = focusCVV,


                modifier = Modifier
                    .onFocusChanged { state ->
                        if (state.isFocused) viewModel.flipped = false
                    }
                    .focusRequester(focusExpiration)
                    .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                    .widthIn(min = 192.dp)
                    .heightIn(min = 60.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .background(App_purple_fade),
            )


            CustomTextField(
                value = viewModel.cvc,
                placeholder = "CVV",
                onValueChange = {
                    InputValidator.parseCVC(it)?.let { cvc ->
                        viewModel.cvc = cvc
                    }
                },
                keyboardType = KeyboardType.Number,

                modifier = Modifier
                    .onFocusEvent { state ->
                        if (state.isFocused) viewModel.flipped = true
                    }
                    .focusRequester(focusCVV)
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
fun MastercardPaymentScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MastercardPaymentDetails(navController, viewModel = CreditCardViewModel())
    }

}


@Preview(showBackground = true)
@Composable
fun MastercardPaymentScreenPreview() {
    val navController = rememberNavController()
    MastercardPaymentScreen(navController)
}
