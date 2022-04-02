package com.uygar.eshop.core

import java.time.ZonedDateTime

data class Order(
    val id: Long,
    val status: Int,
    val orderProducts: List<OrderProduct>,
    val dateAdded: ZonedDateTime
)