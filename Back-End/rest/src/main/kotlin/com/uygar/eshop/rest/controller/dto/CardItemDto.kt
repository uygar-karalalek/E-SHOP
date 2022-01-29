package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

class CardItemDto(

    @JsonProperty("id")
    val id: Long = -1L,

    @JsonProperty("dateAdded")
    val dateAdded: ZonedDateTime

)