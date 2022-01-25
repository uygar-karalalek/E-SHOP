package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ShoppingCardDto (

    @JsonProperty("product")
    var id: Long = -1L,

    @JsonProperty("user")
    var user: UserDto,

    @JsonProperty("cardItems")
    var cardItems: List<CardItemDto>

)