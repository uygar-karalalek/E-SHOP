package com.uygar.eshop.core

import java.time.ZonedDateTime

data class Order(
    val id: Long,
    val userId: Long,
    val totalPrice: Double?,
    val receiverAddress: String?,
    val receiverFullName: String?,
    val status: Int,
    val dateAdded: ZonedDateTime,
    val orderProducts: List<OrderProduct>,
)