package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.persistence.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface ShoppingCardJpaRepository: JpaRepository<ShoppingCard, Long>, ShoppingCardRepository {

}