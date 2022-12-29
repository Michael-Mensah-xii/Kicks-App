package com.example.trainersapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trainersapp.model.DestinationViewModel
import com.example.trainersapp.ui.theme.TrainersAppTheme
import com.example.trainersapp.view.BottomNavigationBar
import com.example.trainersapp.view.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainersAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridActivityScreen(destinationViewModel: DestinationViewModel = viewModel()) {
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
            composable("onBoarding") { }
            composable("home") { }
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")
                    ?.let { /*FoodItemCheck(it, navController, destinationViewModel)*/ }
            }
            composable("cart") { }
            composable("pay_select") { }
            composable("visa_select") { }
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
        "onBoarding" -> {
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