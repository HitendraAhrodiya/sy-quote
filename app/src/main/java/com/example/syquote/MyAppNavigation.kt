package com.example.syquote



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyAppNavigation() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "homePage", builder = {

        composable("homePage") {
            HomePage(navController = navController)
        }
        composable("shayriPage") {
            ShayriPage()
        }


    })
    
}