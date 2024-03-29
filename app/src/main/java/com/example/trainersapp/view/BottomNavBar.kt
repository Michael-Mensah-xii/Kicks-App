package com.example.trainersapp.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.R
import com.example.trainersapp.model.NavigationItem
import com.example.trainersapp.ui.theme.App_purple


//Bottom navigation
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Favourites,
        NavigationItem.Notification,
    )
    val selectedItem = items.first()
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.Black,
        modifier = Modifier,
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                selectedContentColor = App_purple,
                unselectedContentColor = App_purple.copy(0.5f),
                alwaysShowLabel = false,
                selected = item == selectedItem,
                onClick = {

                    if (item.icon == R.drawable.home_icon) {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    } else {

                        null
                    }

                },

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BottomNavigationBar(navController)
}