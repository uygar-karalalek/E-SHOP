package com.uygar.eshop.core

import java.time.ZonedDateTime

data class CardItem(

    val cardId: Long = -1L,
    val productId: Long = -1L,

    val quantity: Int = -1,
    val dateAdded: ZonedDateTime

    )