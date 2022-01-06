package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.User
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findAllByName(name: String): List<User>
    fun findUserById(id: Long): User
}