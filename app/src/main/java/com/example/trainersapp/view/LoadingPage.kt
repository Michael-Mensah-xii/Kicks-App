package com.example.trainersapp.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_grey
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun LoadingPage(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(App_purple),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            // horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

            ) {
            Image(
                painter = painterResource(id = R.drawable.sneaker),
                contentDescription = "sneaker",
                modifier = Modifier.size(570.dp),
                contentScale = ContentScale.Crop
            )

        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        Box(
            modifier = Modifier
                .padding(top = 450.dp)
                .padding(horizontal = 16.dp)
        ) {

            Text(
                buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 40.sp)) {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        ) {
                            append("Life isn")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                color = Color.White
                            )
                        ) {
                            append("’t perfect\n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                color = Color.Black
                            )
                        ) {
                            append("but your\n")

                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                color = Color.Black
                            )
                        ) {
                            append("Sneakers can\n")

                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 40.sp,
                                color = Color.Black
                            )
                        ) {
                            append("be")

                        }
                    }
                }
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 640.dp)
        )
        {
            Text(
                text = "Good shoes take you\nplaces",
                modifier = Modifier
                    .fillMaxWidth() // Take the full width available
                    .wrapContentHeight() // Adjust height based on content
                    .padding(vertical = 8.dp), // Add some vertical padding for spacing
                style = PoppinsTypography.h3,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
            )
        }


        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 735.dp, bottom = 24.dp),
        )
        {
            OutlinedButton(
                modifier = Modifier
                    .heightIn(58.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(32.dp),
                border = BorderStroke(1.dp, App_purple),
                onClick = {
                    navController.navigate("signUp") {
                        popUpTo("signUp") { inclusive = true }
                    }
                }
            )
            {
                Text(
                    text = "Sign Up",
                    style = PoppinsTypography.button,
                    color = App_grey,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier,
                )
            }
        }
    }
}


@Preview
@Composable
fun LoadingPagePreview() {
    val navController = rememberNavController()
    LoadingPage(navController)
}