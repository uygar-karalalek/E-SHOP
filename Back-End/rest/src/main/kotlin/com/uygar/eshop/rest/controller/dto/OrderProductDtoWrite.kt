package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

class OrderProductDtoWrite(

    @JsonProperty("orderId")
    val orderId: Long,

    @JsonProperty("product")
    val product: ProductDto,

    @JsonProperty("quantity")
    val quantity: Int,

    @JsonProperty("dateAdded")
    val dateAdded: ZonedDateTime? = null

)
