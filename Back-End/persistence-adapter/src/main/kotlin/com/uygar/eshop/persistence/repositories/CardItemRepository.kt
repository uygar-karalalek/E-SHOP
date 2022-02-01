package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.CardItem

interface CardItemRepository {
    fun findAll(): List<CardItem>
    fun save(cardItem: CardItem)
}