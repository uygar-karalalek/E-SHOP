package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.ShoppingCard

interface ShoppingCardRepository {
    fun findAll(): List<ShoppingCard>
    fun save(shoppingCard: ShoppingCard)
}