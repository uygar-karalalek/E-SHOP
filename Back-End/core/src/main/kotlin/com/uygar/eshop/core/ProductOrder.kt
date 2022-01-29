package com.uygar.eshop.core

data class ProductOrder (
    val id: Long,
    val product: Product,
    val order: Order,
    val quantity: Int
)