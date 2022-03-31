package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderProductDtoRead(

    @JsonProperty("product")
    val product: ProductDto,

    @JsonProperty("productQuantity")
    val productQuantity: Int

)