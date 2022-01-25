package com.uygar.eshop.core

data class Order(
    val id: Long,
    val status: Boolean,
    val productOrders: List<ProductOrder>
)