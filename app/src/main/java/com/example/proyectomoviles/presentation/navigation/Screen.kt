package com.example.proyectomoviles.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Products : Screen("products")
}