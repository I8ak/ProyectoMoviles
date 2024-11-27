package com.example.proyectomoviles.domain.model

data class Product(
    val name: String,
    val category: String,
    val quantity: Int,
    val price: Double,
    val id: Int
)