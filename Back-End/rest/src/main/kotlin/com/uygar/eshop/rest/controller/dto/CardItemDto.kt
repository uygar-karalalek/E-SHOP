package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

class CardItemDto(

    @JsonProperty("cardId")
    val cardId: Long = -1L,

    @JsonProperty("productPrice")
    val productPrice: Double = 0.0,

    @JsonProperty("productTitle")
    val productTitle: String = "",

    @JsonProperty("productId")
    val productId: Long = -1L,

    @JsonProperty("quantity")
    val quantity: Int = -1,

    @JsonProperty("dateAdded")
    val dateAdded: ZonedDateTime? = null

)