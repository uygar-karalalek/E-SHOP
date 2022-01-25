package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ProductOrderDto(

    @JsonProperty("id")
    val id: Long,

    @JsonProperty("product")
    val product: ProductDto,

    @JsonProperty("order")
    val order: OrderDto

)
