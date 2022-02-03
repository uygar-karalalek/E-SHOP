package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderProduct(

    @JsonProperty("id")
    val id: Long,

    @JsonProperty("product")
    val product: ProductDto,

    @JsonProperty("productQuantity")
    val productQuantity: Int

)