package com.example.proyectomoviles.presentation.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@Composable
fun LoginScreen(navController: NavHostController) {
    Surface (modifier = Modifier.statusBarsPadding()){
        Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(id = R.drawable.logo),
                modifier = Modifier
                    .background(Color.Transparent)
                    .width(100.dp)
                    .height(100.dp).align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
                , contentDescription = "Logo")
            Spacer(modifier = Modifier.padding(5.dp))
            var texto by remember { mutableStateOf("") }
            var textoPass by remember { mutableStateOf("") }
            TextField(value = texto, onValueChange = {newText-> texto=newText}
                ,label= { Text("Username") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.padding(5.dp))
            TextField(value = textoPass, onValueChange = {newPass->textoPass=newPass}
                ,label={ Text(text = "Contraseña") },
                visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Row (modifier = Modifier.align(Alignment.CenterHorizontally)){
                Button(onClick = {  }
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {  }
                ) {
                    Text(text = "Register")
                }
            }
        }
    }
}