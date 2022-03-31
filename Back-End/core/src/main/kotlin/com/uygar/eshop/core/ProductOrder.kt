package com.uygar.eshop.core

data class ProductOrder (
    val orderId: Long,
    val productPrice: Double = 0.0,
    val productTitle: String = "",
    val productId: Long = -1L,
    val quantity: Int = -1
)