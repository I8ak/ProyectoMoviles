package com.example.proyectomoviles.presentation.ui.screens.ListProducts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.domain.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdcutContent(  navController: NavHostController) {
    val products = listOf(
        Product("Assad", "Invierno", 10, 20.5, 7458),
        Product("Luna Rosa", "Primavera", 15, 25.0, 8324),
        Product("Noche Eterna", "Verano", 12, 30.0, 9173),
        Product("Aurora", "Otoño", 8, 18.7, 5641),
        Product("Mystique", "Invierno", 20, 35.2, 1092),
        Product("Velvet", "Primavera", 10, 22.5, 4532),
        Product("Sahara", "Verano", 18, 28.0, 7812),
        Product("Oasis", "Otoño", 25, 32.5, 6327),
        Product("Elegance", "Primavera", 14, 24.0, 2998),
        Product("Noir Absolu", "Invierno", 9, 29.9, 8831)
    )
    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "Productos") })
        },
        content= { padding->
            LazyColumn(Modifier.padding(padding)) {
                items(products) { product ->
                    ProductCard(product)
                }
            }
        },
        bottomBar = {
            BottomAppBar {
                Button(onClick = { navController.navigate("addProduct") }) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "AddProduct")
                }
            }
        }
    )
}

@Composable
fun ProductCard(product: Product) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
        Row {
            if (isSelected) {
                Icon(
                    Icons.Default.Remove,
                    contentDescription = "Contraer",
                    Modifier.clickable { isSelected = false })
                Column {
                    Text(text = product.name, fontWeight = FontWeight.Bold)
                    Text(text = "Categoria: " + product.category)
                    Text(text = "Cantidad: " + product.quantity.toString())
                    Text(text = "Precio: " + product.price)
                    Text(text = "Id: " + product.id)
                }
                Image(
                    Icons.Filled.Edit,
                    contentScale = ContentScale.Fit, // Cambia según tus necesidades
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp),
                    contentDescription = "Producto",
                )
            } else {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Desplegar",
                    Modifier.clickable { isSelected = true })
                Text(text = product.name)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    ProdcutContent(
            navController = rememberNavController()
    )
}