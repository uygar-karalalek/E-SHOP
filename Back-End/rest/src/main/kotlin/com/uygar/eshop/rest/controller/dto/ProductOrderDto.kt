package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ProductOrderDto(

    @JsonProperty("id")
    private val id: Long,

    @JsonProperty("product")
    private val product: ProductDto,

    @JsonProperty("order")
    private val order: OrderDto

)
