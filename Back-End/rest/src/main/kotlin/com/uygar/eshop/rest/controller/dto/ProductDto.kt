package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ProductDto(

    @JsonProperty("id")
    val id: Long,

    @JsonProperty("description")
    val description: String?,

    @JsonProperty("price")
    val price: Double?,

    @JsonProperty("title")
    val title: String?,

    @JsonProperty("productsInCard")
    val cardItems: List<CardItemDto>,

    @JsonProperty("productOrders")
    val productOrders: List<ProductOrderDto>

)