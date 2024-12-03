package com.example.proyectomoviles.presentation.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyectomoviles.R
import com.example.proyectomoviles.presentation.navigation.Screen

@Composable
fun RegisterScreen(navController: NavHostController) {
    // Contenido de la pantalla de registro
    Surface(modifier = Modifier.statusBarsPadding()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                modifier = Modifier
                    .background(Color.Transparent)
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit, contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Spacer(modifier = Modifier.padding(5.dp))
            var user by remember { mutableStateOf("") }
            TextField(
                value = user,
                onValueChange = { newText -> user = newText },
                label = { Text("User name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            var firstname by remember { mutableStateOf("") }
            TextField(
                value = firstname,
                onValueChange = { newText -> firstname = newText },
                label = { Text("First Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            var email by remember { mutableStateOf("") }
            TextField(
                value = email,
                onValueChange = { newText -> email = newText },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { newText -> password = newText },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            val genero = listOf("Masculino", "Femenino")

            var selectedOption by remember { mutableStateOf(genero[0]) }

            Row {
                genero.forEach { item ->
                    Row {
                        RadioButton(
                            selected = (item == selectedOption),
                            onClick = { selectedOption = item }
                        )
                        Text(
                            text = item,
                            modifier = Modifier.clickable { selectedOption = item }
                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))

                }
            }
            Button(onClick = { navController.navigate(Screen.ListProducts.route) }) {
                Text(text = "Create acount")
            }
        }
    }
}