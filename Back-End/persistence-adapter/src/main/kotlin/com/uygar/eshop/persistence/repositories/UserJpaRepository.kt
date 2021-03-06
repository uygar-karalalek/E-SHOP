package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserJpaRepository: JpaRepository<User, Long>, UserRepository