package com.uygar.eshop.core

data class ProductOrder (
    val id: Long,
    val product: Product,
    val quantity: Int
)