package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @CrossOrigin(origins = ["http://localhost:8080"])
    @GetMapping
    fun getUsers(): Long {
        return userService.getAllUsers().get(0).id
    }

}