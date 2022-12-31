package com.example.trainersapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.model.DestinationViewModel
import com.example.trainersapp.ui.theme.TrainersAppTheme
import com.example.trainersapp.view.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainersApp()

        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun TrainersApp(destinationViewModel: DestinationViewModel = viewModel()) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    // State of topBar & bottomBar, set state to false, if current page route is "onBoarding"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    BottomBarAnimation(navController, bottomBarState, topBarState)


    Log.d("ActivityScreen_title", destinationViewModel.title.value)

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null

    }

    Scaffold(

        topBar = {
            if (topBarState.value) {
                TopBar(navController)
            }
        },
        bottomBar = {
            if (bottomBarState.value) {
                BottomNavigationBar(navController)
            }
        }

    ) {
        NavHost(navController = navController, startDestination = "onBoarding") {
            composable("onBoarding") {LoadingPage(navController)}
            composable("signUp") { SignUpScreen(navController) }
            composable("home") { HomeScreen(navController) }
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")
                    ?.let { ShoeViewPage(it, navController, destinationViewModel) }
            }
            composable("cart") { CartScreen(navController)}
            composable("pay_select") { PaymentList(navController) }
            composable("visa_select") {VisaPaymentScreen(navController)}
            composable("mastercard_select") { MastercardPaymentScreen(navController)}
        }
    }
}


@Composable
fun BottomBarAnimation(
    navController: NavController,
    bottomBarState: MutableState<Boolean>,
    topBarState: MutableState<Boolean>,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Control BottomBar
    when (navBackStackEntry?.destination?.route) {
        "onBoarding","signUp","cart","details/{listId}","mastercard_select","visa_select","pay_select" -> {
            // Hide BottomBar
            bottomBarState.value = false
            // Hide TopBar
            topBarState.value = false
        }
        else -> {
            // Show BottomBar
            bottomBarState.value = true
            // Show TopBar
            topBarState.value = true
        }
    }



}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainersAppTheme {
        Greeting("Android")
    }
}