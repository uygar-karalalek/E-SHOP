package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.ShoppingCard
import java.util.*

interface ShoppingCardRepository {
    fun findAll(): List<ShoppingCard>
    fun findById(id: Long): Optional<ShoppingCard>
    fun save(card: ShoppingCard)
}