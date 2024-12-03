package com.example.proyectomoviles.presentation.ui.screens.addProduct

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.ui.theme.ProyectoMovilesTheme

@Composable
fun AddProductsScreen( navController: NavController) {

    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf(0.0) }
    var id by remember { mutableStateOf(0) }
    var quantity by remember { mutableStateOf(0) }
    Column(modifier = Modifier.statusBarsPadding()) {
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = name,
            onValueChange = {newText->name=newText},
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = category,
            onValueChange = {newText->category =newText},
            label = { Text(text = "Categoria") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = precio.toString(),
            onValueChange ={newText->precio =newText.toDouble()},
            label = { Text(text = "Precio") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = quantity.toString(),
            onValueChange ={newText->quantity =newText.toInt()},
            label = { Text(text = "Cantidad") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = id.toString(),
            onValueChange = {newText->id =newText.toInt()},
            label = { Text(text = "ID") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = {}, modifier = Modifier.align(Alignment.End) ){
            Text("Añadir")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProyectoMovilesTheme {
        AddProductsScreen(navController = rememberNavController())
    }
}