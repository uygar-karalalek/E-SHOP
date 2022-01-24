package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderDto (

    @JsonProperty("order")
    private val id: Long,

    @JsonProperty("status")
    private val status: Boolean,

    @JsonProperty("productOrders")
    private val productOrders: Set<ProductOrderDto>

)
