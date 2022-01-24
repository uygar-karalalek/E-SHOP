package com.uygar.eshop.core

data class ProductOrder (
    private val id: Long,
    private val product: Product,
    private val order: Order
)