package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class UserDto (

    @JsonProperty("id")
    val id: Long?,

    @JsonProperty("name")
    val name: String?,

    @JsonProperty("surname")
    val surname: String?,

    @JsonProperty("address")
    val address: String?,

    @JsonProperty("email")
    val email: String?,

    @JsonProperty("password")
    val password: String?,

    @JsonProperty("guest")
    val guest: Boolean?,

    @JsonProperty("shoppingCard")
    val shoppingCard: ShoppingCardDto?

)
