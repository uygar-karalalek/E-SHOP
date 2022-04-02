package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.persistence.keys.CardItemKey
import java.util.*

interface CardItemRepository {
    fun findByCardIdAndProductId(cardId: Long, productId: Long): Optional<CardItem>
    fun incrementItemQuantity(cardId: Long, productId: Long, quantity: Int)
    fun deleteById(cardId: Long, productId: Long)
    fun findAll(): List<CardItem>
    fun save(cardItem: CardItem)
}