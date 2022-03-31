package com.uygar.eshop.core

data class Order(
    val id: Long,
    val status: Int,
    val productOrders: List<ProductOrder>
)