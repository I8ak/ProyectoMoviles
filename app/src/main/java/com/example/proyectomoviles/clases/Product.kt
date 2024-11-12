package com.example.proyectomoviles.clases

data class Product(
    val name: String,
    val category: Category,
    val quantity: Int,
    val price: Double,
    val id: Int
)