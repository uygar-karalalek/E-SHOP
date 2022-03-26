package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.AuthenticationDto
import com.uygar.eshop.rest.controller.dto.LoginDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/login")
@RestController
class LoginController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun login(@RequestBody loginDto: LoginDto): AuthenticationDto {
        return AuthenticationDto(userService.getAllUsers()
            .find { it.email == loginDto.email && it.password == loginDto.password }!!.let {
                return@let it.address.substringBefore('@')
            }
        )
    }

}