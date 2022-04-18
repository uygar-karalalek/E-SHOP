package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ShoppingCardDto (

    @JsonProperty("userId")
    var userId: Long = -1L,

)