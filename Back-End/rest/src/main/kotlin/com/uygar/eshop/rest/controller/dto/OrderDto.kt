package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderDto (

    @JsonProperty("order")
    val id: Long,

    @JsonProperty("status")
    val status: Boolean,

    @JsonProperty("productOrders")
    val productOrders: List<ProductOrderDto>

)
