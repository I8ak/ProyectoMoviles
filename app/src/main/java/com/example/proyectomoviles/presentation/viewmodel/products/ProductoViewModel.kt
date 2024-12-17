package com.example.proyectomoviles.presentation.viewmodel.products

import androidx.lifecycle.ViewModel
import com.example.proyectomoviles.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductoViewModel: ViewModel() {
    private val _productos = MutableStateFlow(
        Product("","",0,0.0,0)
    )
    fun setId(id: Int) {
        _productos.value = _productos.value.copy(id = id)
    }
    val productos: MutableStateFlow<Product> = _productos

    fun setName(name: String) {
        _productos.value = _productos.value.copy(name = name)
    }
    fun setCategory(category: String) {
        _productos.value = _productos.value.copy(category = category)
    }
    fun setQuantity(quantity: Int) {
        _productos.value = _productos.value.copy(quantity = quantity)
    }
    fun setPrice(price: Double) {
        _productos.value = _productos.value.copy(price = price)

    }
    fun getId(): Int {
        return _productos.value.id
    }
    fun getName(): String {
        return _productos.value.name
    }
    fun getCategory(): String {
        return _productos.value.category
    }
    fun getQuantity(): Int {
        return _productos.value.quantity
    }
    fun getPrice(): Double {
        return _productos.value.price
    }


}