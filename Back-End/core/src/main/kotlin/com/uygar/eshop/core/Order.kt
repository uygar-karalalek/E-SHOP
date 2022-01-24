package com.uygar.eshop.core

data class Order(
    private val id: Long,
    private val status: Boolean,
    private val productOrders: Set<ProductOrder>
)