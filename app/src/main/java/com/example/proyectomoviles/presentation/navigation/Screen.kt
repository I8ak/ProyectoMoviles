package com.example.proyectomoviles.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object ListProducts : Screen("products")
    object AddProduct : Screen("addProduct")
    object Register : Screen("register")


}