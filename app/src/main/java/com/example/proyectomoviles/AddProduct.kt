package com.example.proyectomoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectomoviles.ui.theme.ProyectoMovilesTheme

class AddProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMovilesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AddProducts(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AddProducts( modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    Column(modifier = modifier.statusBarsPadding()) {
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = text,
            onValueChange = {newText->text=newText},
            label = { Text("Nombre")}
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProyectoMovilesTheme {
        AddProducts()
    }
}