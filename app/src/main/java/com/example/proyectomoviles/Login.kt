package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyectomoviles.presentation.navigation.NavGraph
import com.example.proyectomoviles.presentation.ui.screens.login.LoginScreen
import com.example.proyectomoviles.ui.theme.ProyectoMovilesTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMovilesTheme {
                NavGraph()
            }
        }
    }
}

