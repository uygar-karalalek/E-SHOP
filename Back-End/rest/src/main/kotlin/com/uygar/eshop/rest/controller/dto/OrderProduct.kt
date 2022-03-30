package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderProduct(

    @JsonProperty("orderId")
    val orderId: Long,

    @JsonProperty("productId")
    val productId: Long,

    @JsonProperty("product")
    val product: ProductDto,

    @JsonProperty("productQuantity")
    val productQuantity: Int

)
