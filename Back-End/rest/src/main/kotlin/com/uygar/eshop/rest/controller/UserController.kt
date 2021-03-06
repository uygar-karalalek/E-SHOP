package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.UserDto
import com.uygar.eshop.rest.controller.dto.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/users")
@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userService.getAllUsers().map(UserMapper::mapToDto)
    }

    @GetMapping("/get/{token}")
    fun getUserByToken(@PathVariable token: String): UserDto {
        return userService.getAllUsers()
            .map(UserMapper::mapToDto)
            .filter { user ->
                return@filter user.email != null &&
                        user.email.startsWith(token)
            }
            .first()
    }

    @PostMapping("/add")
    fun saveUser(@RequestBody user: UserDto): UserDto {
        return UserMapper.mapToDto(userService.saveUser(UserMapper.mapToDomain(user)))
    }

}