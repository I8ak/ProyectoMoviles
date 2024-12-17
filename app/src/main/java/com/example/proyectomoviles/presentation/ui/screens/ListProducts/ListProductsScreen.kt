package com.example.proyectomoviles.presentation.ui.screens.ListProducts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.domain.model.Product
import com.example.proyectomoviles.presentation.viewmodel.products.ProductowViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdcutContent(navController: NavHostController, viewModel: ProductowViewModel) {

    val productos by viewModel.productos.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Productos") })
        },
        content = { padding ->
            LazyColumn(Modifier.padding(padding)) {
                items(productos) { product ->
                    key(product) {
                        ProductCard(product, viewModel, navController)
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar {
                Button(onClick = { navController.navigate("addProduct") }) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "AddProduct"
                    )
                }
            }
        }
    )
}

@Composable
fun ProductCard(product: Product, viewModel: ProductowViewModel,navController: NavHostController) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
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

                Column {
                    Icon(
                        Icons.Filled.Edit,
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable { navController.navigate("updateProduct") }
                            .align(Alignment.End),
                        contentDescription = "Editar",
                        )
                    Icon(
                        Icons.Filled.Delete,
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .clickable { viewModel.removeProduct(product.id) }
                            .align(Alignment.End),
                        contentDescription = "Eliminar",

                        )
                }
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
        navController = rememberNavController(), viewModel()
    )
}