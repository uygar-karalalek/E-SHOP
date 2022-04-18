package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.User

interface UserRepository {
    fun findAll(): List<User>
    fun deleteById(id: Long)
    fun save(user: User): User
}