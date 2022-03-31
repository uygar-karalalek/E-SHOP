package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class OrderWithItemsDto (

    @JsonProperty("order")
    val id: Long,

    @JsonProperty("status")
    val status: Int? = null,

    @JsonProperty("orderProducts")
    val orderProducts: List<OrderProductDtoWrite>

)
