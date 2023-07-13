package com.example.trainersapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.ui.theme.App_purple
import com.example.trainersapp.ui.theme.PoppinsTypography


@Composable
fun TopBar(
    navController: NavController,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(App_purple),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Profile()


        Row(
            modifier = Modifier
                .widthIn(42.dp),
        )
        {

            IconButton(onClick = { }) {
                Icon(
                    modifier = Modifier.size(32.dp, 32.dp),
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }

            IconButton(onClick = {
                navController.navigate("cart") {
                    popUpTo("cart") { inclusive = true }
                }
            }) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "cart",
                    tint = Color.Black
                )
            }

        }
    }

}

@Composable
fun Profile() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier
                .padding(top = 4.dp)
                .size(40.dp)
                .clip(CircleShape)

        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = stringResource(R.string.greeting_morning),
                style = PoppinsTypography.h3,
                fontSize = 15.sp

            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = stringResource(R.string.user_name),
                style = PoppinsTypography.body1,
                fontSize = 13.sp
            )
        }
    }

}


@Preview
@Composable
fun SimplePreview() {
    val navController = rememberNavController()
    TopBar(navController)
}

@Preview
@Composable
fun ProfilePreview() {
    Profile()
}
