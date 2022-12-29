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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.*

@Composable
fun SignUp() {
    Column(Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 16.dp)) {
        val textState = rememberSaveable { mutableStateOf("") }
        val textState1 = rememberSaveable { mutableStateOf("") }
        val textState2 = rememberSaveable { mutableStateOf("") }
        val textState3 = rememberSaveable { mutableStateOf("") }

        Row(modifier = Modifier
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
            value = textState.value,
            onValueChange = { textState.value = it },
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
            value = textState1.value,
            onValueChange = { textState1.value = it },
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
            value = textState2.value,
            onValueChange = { textState2.value = it },
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
            value = textState3.value,
            onValueChange = { textState3.value = it },
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

        Text(
            text = "Already have an account? Login",
            modifier = Modifier.fillMaxWidth(),
            style = PoppinsTypography.body1,
            color = App_purple,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.heightIn(24.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(thickness = 0.5.dp, color = App_divider_colour,
                modifier = Modifier
                    .width(126.dp))


            Text(
                text = "Or Sign up with",
                modifier = Modifier.widthIn(min = 102.dp),
                style = PoppinsTypography.body1,
                color = App_grey,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
            )

            Divider(thickness = 0.5.dp, color = App_divider_colour,
                modifier = Modifier
                    .width(126.dp))

        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        Column()
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
fun SignUpPreview() {
    SignUp()
}