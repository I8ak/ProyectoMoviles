package com.example.proyectomoviles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.presentation.ui.screens.ListProducts.ProdcutContent
import com.example.proyectomoviles.presentation.ui.screens.addProduct.AddProductsScreen
import com.example.proyectomoviles.presentation.ui.screens.login.LoginScreen
import com.example.proyectomoviles.presentation.ui.screens.register.RegisterScreen

@Composable
fun NavGraph(startDestination: String=Screen.Login.route) {
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination=startDestination){
        composable(Screen.Login.route){
            LoginScreen(navController)
        }
        composable(Screen.ListProducts.route){
            ProdcutContent(navController)
        }
        composable(Screen.AddProduct.route){
            AddProductsScreen(navController)
        }
        composable(Screen.Register.route){
            RegisterScreen(navController)
        }
    }
}