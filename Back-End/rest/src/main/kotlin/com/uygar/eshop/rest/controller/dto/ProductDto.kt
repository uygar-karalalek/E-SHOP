package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.uygar.eshop.persistence.entities.ShoppingCard

class ProductDto (

    @JsonProperty("description")
    private val description: String,

    @JsonProperty("price")
    private val price: Double,

    @JsonProperty("title")
    private val title: String?

)
