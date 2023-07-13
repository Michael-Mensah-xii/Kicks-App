package com.example.trainersapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.model.LoginViewModel
import com.example.trainersapp.ui.theme.App_divider_colour
import com.example.trainersapp.ui.theme.App_grey
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.App_purple_fade
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: LoginViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {

        Column {
            Text(text = "Skip", modifier = Modifier
                .widthIn(40.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate("home") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sign Up",
                style = PoppinsTypography.h1,
                fontSize = 26.sp,
            )
        }
        Spacer(modifier = Modifier.heightIn(32.dp))

        OutlinedTextField(
            value = viewModel.firstname,
            onValueChange = { viewModel.firstname = it },
            placeholder = {
                Text(
                    "First Name",
                    style = PoppinsTypography.body1,
                    fontSize = 16.sp,
                )
            },
            modifier = Modifier
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),

            )

        Spacer(modifier = Modifier.heightIn(24.dp))

        OutlinedTextField(
            value = viewModel.lastname,
            onValueChange = { viewModel.lastname = it },
            placeholder = {
                Text(
                    "Last Name",
                    style = PoppinsTypography.body1,
                    fontSize = 16.sp,
                )
            },
            modifier = Modifier
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),

            )

        Spacer(modifier = Modifier.heightIn(24.dp))

        OutlinedTextField(
            value = viewModel.phone,
            onValueChange = { viewModel.phone = it },
            placeholder = {
                Text(
                    "Phone",
                    style = PoppinsTypography.body1,
                    fontSize = 16.sp,
                )
            },
            modifier = Modifier
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),

            )

        Spacer(modifier = Modifier.heightIn(24.dp))

        OutlinedTextField(
            value = viewModel.paswword,
            onValueChange = { viewModel.paswword = it },
            placeholder = {
                Text(
                    "Password",
                    style = PoppinsTypography.body1,
                    fontSize = 16.sp,
                )
            },
            modifier = Modifier
                .border(2.dp, color = App_purple_fade, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .heightIn(min = 60.dp)
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .background(App_purple_fade),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.hide_password),
                    "",
                    tint = Color.Unspecified,
                )
            }

        )

        Spacer(modifier = Modifier.heightIn(48.dp))

        Column()
        {
            Button(
                modifier = Modifier
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                colors = (ButtonDefaults.buttonColors(App_purple)),
                onClick = { /*TODO*/ })
            {
                Text(
                    text = "Sign Up",
                    style = PoppinsTypography.button,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        Column {
            Text(
                text = "Already have an account? Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { },
                style = PoppinsTypography.body1,
                color = App_purple,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                thickness = 0.5.dp, color = App_divider_colour,
                modifier = Modifier
                    .width(126.dp)
            )


            Column {
                Text(
                    text = "Or Sign up with",
                    modifier = Modifier
                        .widthIn(min = 102.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { },
                    style = PoppinsTypography.body1,
                    color = App_grey,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Divider(
                thickness = 0.5.dp, color = App_divider_colour,
                modifier = Modifier
                    .width(126.dp)
            )

        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        Column(
            modifier = Modifier
                .padding(bottom = 32.dp)
        )
        {
            OutlinedButton(
                modifier = Modifier
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                border = BorderStroke(1.dp, App_purple),
                onClick = { /*TODO*/ })
            {
                Icon(
                    painter = painterResource(id = R.drawable.google_logo),
                    modifier = Modifier.size(32.dp),
                    contentDescription = "drawable icons",
                    tint = Color.Unspecified
                )
                Text(
                    text = "Google",
                    style = PoppinsTypography.button,
                    color = App_grey,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .offset(x = (-24).dp / 2) //offset icon to left of button
                )
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()

    SignUpScreen(navController, viewModel = LoginViewModel())
}