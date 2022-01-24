package com.uygar.eshop.core

data class User(
    val id: Long = -1L,
    val name: String,
    val surname: String,
    val address: String,
    val email: String,
    val password: String,
    val shoppingCard: ShoppingCard
)