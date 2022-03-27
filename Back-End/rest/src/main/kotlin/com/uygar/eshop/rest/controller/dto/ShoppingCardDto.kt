package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ShoppingCardDto (

    @JsonProperty("id")
    var id: Long = -1L,

    @JsonProperty("cardItems")
    var cardItems: List<CardItemDto>

)