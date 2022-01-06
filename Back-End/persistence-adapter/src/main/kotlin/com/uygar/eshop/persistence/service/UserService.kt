package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.User
import com.uygar.eshop.persistence.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList()
    }

}