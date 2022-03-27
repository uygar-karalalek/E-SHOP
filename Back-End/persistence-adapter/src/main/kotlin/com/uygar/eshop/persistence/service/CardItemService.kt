package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.entities.mapper.CardItemMapper
import com.uygar.eshop.persistence.repositories.CardItemRepository
import java.util.*

class CardItemService(private val cardItemRepository: CardItemRepository) {

    fun getAllCardItems(): List<CardItem> {
        return cardItemRepository.findAll().map(CardItemMapper::mapToDomain)
    }

    fun addItem(cardItem: CardItem) {
        val searchedCardItem = cardItemRepository.findByCardIdAndProductId(cardItem.cardId, cardItem.productId)
        if (searchedCardItem.isPresent) cardItemRepository.incrementItemQuantity(cardItem.cardId, cardItem.productId, 1)
        else cardItemRepository.save(CardItemMapper.mapToEntity(cardItem))
    }

    fun removeItemByIds(cardId: Long, productId: Long) {
        cardItemRepository.incrementItemQuantity(cardId, productId, -1)
    }

    fun insertItemByIds(cardId: Long, productId: Long) {
        cardItemRepository.incrementItemQuantity(cardId, productId, 1)
    }

    fun findItemById(shoppingCardId: Long, productId: Long): CardItem {
        val cardItemEntity = cardItemRepository.findByCardIdAndProductId(shoppingCardId, productId)
        if (cardItemEntity.isPresent) return CardItemMapper.mapToDomain(cardItemEntity.get())
        else throw NoSuchElementException("Card with id id $shoppingCardId and $productId not found")
    }

}