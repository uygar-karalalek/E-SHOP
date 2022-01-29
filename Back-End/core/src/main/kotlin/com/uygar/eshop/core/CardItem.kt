package com.uygar.eshop.core

import java.time.ZonedDateTime

data class CardItem(
    val id: Long = -1L,
    val dateAdded: ZonedDateTime
)