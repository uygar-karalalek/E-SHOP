package com.uygar.eshop.core

import java.time.ZonedDateTime

data class CardItem(

    val cardId: Long = -1L,
    val productPrice: Double = 0.0,
    val productTitle: String = "",
    val productId: Long = -1L,
    val quantity: Int = -1,
    val dateAdded: ZonedDateTime = ZonedDateTime.now()

)