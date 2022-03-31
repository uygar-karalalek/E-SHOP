package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ProductDto(

    @JsonProperty("id")
    val id: Long,

    @JsonProperty("price")
    val price: Double?,

    @JsonProperty("title")
    val title: String?

)