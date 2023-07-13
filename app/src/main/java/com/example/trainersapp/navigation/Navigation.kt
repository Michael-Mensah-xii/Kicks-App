package com.example.trainersapp.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.model.LoginViewModel
import com.example.trainersapp.model.ShoeViewModel
import com.example.trainersapp.view.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun TrainersApp() {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    // State of topBar & bottomBar, set state to false, if current page route does not need it
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    BottomBarAnimation(navController, bottomBarState, topBarState)


    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null

    }

    Scaffold(

        topBar = {
            if (topBarState.value) {
                TopBar(navController)
            }
        }, bottomBar = {
            if (bottomBarState.value) {
                BottomNavigationBar(navController)
            }
        }

    ) {
        NavHost(navController = navController, startDestination = Screen.LoadingPage.route) {

            //OnBoarding Screen
            composable(route = Screen.LoadingPage.route) { LoadingPage(navController) }


            //SignUpScreen
            composable(route = Screen.SignUpScreen.route) {
                SignUpScreen(
                    navController, LoginViewModel()
                )
            }


            //HomeScreen
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(onItemClicked = { item ->
                    navController.navigate(Screen.ShoeViewPage.createRouteWithItem(item))
                })
            }


            //SimilarMatchRow Screen
            composable(route = Screen.SimilarMatchRow.route) { SimilarMatchRow(onItemClicked = {}) }


            //ShoeViewPage Screen
            composable(route = Screen.ShoeViewPage.route) { backStackEntry ->
                backStackEntry.arguments?.getString("item")?.let {
                    ShoeViewPage(ShoeViewModel(it), onBackPress = {
                        navController.navigate(Screen.HomeScreen.route) {
                            navController.navigateUp()
                        }
                    }, onItemClicked = { item ->
                        navController.navigate(Screen.ShoeViewPage.createRouteWithItem(item))
                    })
                }
            }

            //OnBoarding Screen
            composable(route = Screen.CartScreen.route) { CartScreen(navController) }

            //PaymentList Screen
            composable(route = Screen.PaymentList.route) {
                PaymentList(openVisaPayment = {
                    navController.navigate("visa_select") {
                        popUpTo("visa_select") { inclusive = true }
                    }
                }, openMasterCardPayment = {
                    navController.navigate("mastercard_select") {
                        popUpTo("mastercard_select") { inclusive = true }
                    }
                }, upPress = { navController.navigateUp() })
            }

            //VisaPaymentScreen
            composable(route = Screen.VisaPaymentScreen.route) { VisaPaymentScreen(upPress = { navController.navigateUp() }) }

            //MastercardPaymentScreen
            composable(route = Screen.MastercardPaymentScreen.route) {
                MastercardPaymentScreen(upPress = { navController.navigateUp() })
            }
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
    if (navBackStackEntry?.destination?.route != "home") {
        // Hide BottomBar
        bottomBarState.value = false
        // Hide TopBar
        topBarState.value = false
    } else {
        // Show BottomBar
        bottomBarState.value = true
        // Show TopBar
        topBarState.value = true
    }
}


