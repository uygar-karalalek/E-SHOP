package com.uygar.eshop.rest.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

class AuthenticationDto(

    @JsonProperty("token")
    val token: String? = null

)