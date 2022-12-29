package com.example.trainersapp.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_grey
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.PoppinsTypography

@Composable
fun LoadingPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(App_purple)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,

            ) {
            Image(painter = painterResource(id = R.drawable.sneaker),
                contentDescription = "mastercard",
                modifier = Modifier.size(570.dp),
                contentScale = ContentScale.Crop
            )
        }


    }
    Box(
        modifier = Modifier
            .padding(top = 450.dp)
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = "Good shoes take you\nplaces",
            modifier = Modifier
                .widthIn(90.dp)
                .heightIn(72.dp)
                .padding(top = 175.dp),
            style = PoppinsTypography.h3,
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
        )

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
            .padding(horizontal = 16.dp)
            .padding(top=740.dp),
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


@Preview
@Composable
fun LoadingPagePreview() {
    LoadingPage()
}