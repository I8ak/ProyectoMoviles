package com.example.proyectomoviles.presentation.navigation

import TasksViewModel
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomoviles.presentation.ui.screens.ListProducts.ProdcutContent
import com.example.proyectomoviles.presentation.ui.screens.addProduct.AddProductsScreen
import com.example.proyectomoviles.presentation.ui.screens.edit.EditProductScreen
import com.example.proyectomoviles.presentation.ui.screens.login.LoginScreen
import com.example.proyectomoviles.presentation.ui.screens.register.RegisterScreen
import com.example.proyectomoviles.presentation.viewmodel.products.ProductoViewModel
import com.example.proyectomoviles.presentation.viewmodel.products.ProductowViewModel

@Composable
fun NavGraph(startDestination: String=Screen.Login.route) {
    val navController=rememberNavController()
    val productsViewModel: ProductowViewModel = viewModel()
    val tasksViewModel: TasksViewModel = viewModel()
    val productoViewModel: ProductoViewModel = viewModel()
    NavHost(navController=navController,startDestination=startDestination){
        composable(Screen.Login.route){
            LoginScreen(navController, viewModel())
        }
        composable(Screen.ListProducts.route){
            ProdcutContent(navController,productsViewModel)
        }
        composable(Screen.AddProduct.route){
            AddProductsScreen(navController, productsViewModel,productoViewModel )
        }
        composable(Screen.Register.route){
            RegisterScreen(navController)
        }
        composable(Screen.UpdateProduct.route){
            EditProductScreen(navController, productsViewModel,productoViewModel)
        }
    }
}