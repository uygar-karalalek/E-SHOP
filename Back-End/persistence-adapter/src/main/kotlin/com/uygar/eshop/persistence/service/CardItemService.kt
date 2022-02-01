package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.CardItem

import com.uygar.eshop.persistence.entities.mapper.CardItemMapper
import com.uygar.eshop.persistence.repositories.CardItemRepository

class CardItemService(private val productRepository: CardItemRepository) {

    fun getAllProducts(): List<CardItem> {
        return productRepository.findAll().map(CardItemMapper::mapToDomain)
    }

    fun  addItem(cardItem: CardItem) {
        productRepository.save(CardItemMapper.mapToEntity(cardItem))
    }

}