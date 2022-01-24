package com.uygar.eshop.core

import java.time.ZonedDateTime

data class CardItem (
    private val id: Long = -1L,
    private val dateAdded: ZonedDateTime,
    private val shoppingCard: ShoppingCard,
    private val product: Product
)