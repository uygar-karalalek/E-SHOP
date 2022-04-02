package com.uygar.eshop.core

data class OrderProduct (
    val orderId: Long,
    val productPrice: Double = 0.0,
    val productTitle: String = "",
    val productId: Long = -1L,
    val quantity: Int = -1,
)