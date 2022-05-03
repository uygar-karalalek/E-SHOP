package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

class OrderDto (

    @JsonProperty("id")
    val id: Long? = null,

    @JsonProperty("status")
    val status: Int? = null,

    @JsonProperty("userId")
    val userId: Long? = null,

    @JsonProperty("receiverAddress")
    val receiverAddress: String? = null,

    @JsonProperty("receiverFullName")
    val receiverFullName: String? = null,

    @JsonProperty("totalPrice")
    val totalPrice: Double? = null,

    @JsonProperty("dateAdded")
    val dateAdded: ZonedDateTime? = null,

    @JsonProperty("orderProducts")
    val orderProducts: List<OrderProductDto>? = listOf()

)