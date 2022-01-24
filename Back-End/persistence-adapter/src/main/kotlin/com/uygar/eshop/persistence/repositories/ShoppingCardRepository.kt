package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.ShoppingCard

interface ShoppingCardRepository {
    fun findAll(): List<ShoppingCard>
    fun findById(id: Long): ShoppingCard
    fun saveProductById(id: Long, product: Product)
    fun save(card: ShoppingCard)
}