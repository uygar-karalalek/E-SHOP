package com.uygar.eshop.core

data class ShoppingCard (
    var userId: Long = -1L,
    var cardItems: List<CardItem>
)