package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class LoginDto(

    @JsonProperty("email")
    val email: String?,

    @JsonProperty("password")
    val password: String?

)