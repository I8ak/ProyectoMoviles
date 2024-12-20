package com.example.proyectomoviles.presentation.ui.screens.addProduct

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.domain.model.Product
import com.example.proyectomoviles.presentation.navigation.Screen
import com.example.proyectomoviles.presentation.viewmodel.products.ProductoViewModel
import com.example.proyectomoviles.presentation.viewmodel.products.ProductowViewModel
import com.example.proyectomoviles.ui.theme.ProyectoMovilesTheme

@Composable
fun AddProductsScreen(
    navController: NavController,
    viewModel: ProductowViewModel,
    productsViewModel: ProductoViewModel
) {

    var borrarTaxt by remember { mutableStateOf(false) }
    val product by productsViewModel.productos.collectAsState()
    if (borrarTaxt) {
        productsViewModel.setName("")
        productsViewModel.setCategory("")
        productsViewModel.setPrice(0.0)
        productsViewModel.setQuantity(0)
        productsViewModel.setId(0)
    }
    Column(modifier = Modifier.statusBarsPadding()) {
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = product.name,
            onValueChange = { productsViewModel.setName(it) },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = product.category,
            onValueChange = { productsViewModel.setCategory(it) },
            label = { Text(text = "Categoria") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value =product.price.toString(),
            onValueChange = { productsViewModel.setPrice(it.toDouble()) },
            label = { Text(text = "Precio") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = product.quantity.toString(),
            onValueChange = { productsViewModel.setQuantity(it.toInt()) },
            label = { Text(text = "Cantidad") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            value = product.id.toString(),
            onValueChange = { productsViewModel.setId(it.toInt()) },
            label = { Text(text = "ID") }
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier.align(Alignment.End)) {
            Button(onClick = { navController.navigate(Screen.ListProducts.route) }) {
                Text("Lista de productos")
            }

            Button(onClick = {
                viewModel.addProduct(Product(product.name, product.category, product.quantity, product.price, product.id))
                borrarTaxt = true
                navController.navigate(Screen.ListProducts.route)
            }) {
                Text("Añadir")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ProyectoMovilesTheme {
        AddProductsScreen(navController = rememberNavController(), viewModel(),productsViewModel = ProductoViewModel() )
    }
}