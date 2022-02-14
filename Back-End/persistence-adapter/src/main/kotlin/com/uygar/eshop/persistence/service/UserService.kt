package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.User
import com.uygar.eshop.persistence.entities.mapper.UserMapper
import com.uygar.eshop.persistence.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll().map(UserMapper::mapToDomain).toList()
    }

    fun deleteUserById(userId: Long) {
        userRepository.deleteById(userId)
    }

}