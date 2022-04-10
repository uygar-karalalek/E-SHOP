package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

class OrderDto (

    @JsonProperty("orderId")
    val id: Long? = null,

    @JsonProperty("status")
    val status: Int? = null,

    @JsonProperty("userId")
    val userId: Long? = null,

    @JsonProperty("dateAdded")
    val dateAdded: ZonedDateTime? = null
)
