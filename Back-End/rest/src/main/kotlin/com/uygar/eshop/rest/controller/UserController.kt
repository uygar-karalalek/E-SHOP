package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.UserDto
import com.uygar.eshop.rest.controller.dto.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userService.getAllUsers().map(UserMapper::mapToDto)
    }

}