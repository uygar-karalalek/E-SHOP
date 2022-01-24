package com.uygar.eshop.core

data class ShoppingCard (
    var id: Long = -1L,
    var user: User,
    var productsInCard: Set<CardItem>
)