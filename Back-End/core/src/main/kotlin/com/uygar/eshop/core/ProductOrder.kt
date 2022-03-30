package com.uygar.eshop.core

data class ProductOrder (
    val orderId: Long,
    val productId: Long,
    val product: Product,
    val quantity: Int
)