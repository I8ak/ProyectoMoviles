package com.example.proyectomoviles.presentation.viewmodel.products

import androidx.lifecycle.ViewModel
import com.example.proyectomoviles.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductowViewModel:ViewModel() {
    private val _productos= MutableStateFlow(
        listOf(
            Product("Lattafa Assad", "Invierno", 10, 20.5, 7458),
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
    )
    val productos: StateFlow<List<Product>> = _productos

    fun addProduct(product: Product){
        _productos.value= _productos.value+product
    }

    fun removeProduct(id:Int){
        _productos.value=_productos.value.filter { it.id!=id }
    }
    fun editProduct(product: Product){
        _productos.value=_productos.value.filter { it.id!=product.id }
        _productos.value=_productos.value+product

    }
}