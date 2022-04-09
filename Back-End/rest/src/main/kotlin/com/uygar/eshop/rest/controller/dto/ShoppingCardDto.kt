package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ShoppingCardDto (

    @JsonProperty("user_id")
    var userId: Long = -1L,

)