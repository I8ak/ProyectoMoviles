package com.example.proyectomoviles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.ListProducts
import com.example.proyectomoviles.presentation.ui.screens.login.LoginScreen

@Composable
fun NavGraph(startDestination: String=Screen.Login.route) {
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination=startDestination){
        composable(Screen.Login.route){
            LoginScreen(navController)
        }
        composable(Screen.Products.route){
            ListProducts(navController)
        }
    }
}