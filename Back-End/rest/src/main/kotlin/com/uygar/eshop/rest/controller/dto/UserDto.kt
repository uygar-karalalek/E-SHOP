package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class UserDto (

    @JsonProperty("name")
    private val name: String?,

    @JsonProperty("surnname")
    private val surname: String?,

    @JsonProperty("address")
    private val address: String?,

    @JsonProperty("email")
    private val email: String?,

    @JsonProperty("password")
    private val password: String?,

    @JsonProperty("shoppingCard")
    private val shoppingCard: ShoppingCardDto?

)
