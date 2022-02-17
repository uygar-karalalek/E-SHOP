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
        if (searchedCardItem.isPresent) {
            searchedCardItem.get().quantity++
            cardItemRepository.save(searchedCardItem.get())
        } else {
            cardItemRepository.save(CardItemMapper.mapToEntity(cardItem))
        }
    }

    fun removeItem(cardItem: CardItem) {
        val searchedCardItem = cardItemRepository.findByCardIdAndProductId(cardItem.cardId, cardItem.productId)
        if (searchedCardItem.isPresent) {
            searchedCardItem.get().quantity--
            cardItemRepository.save(searchedCardItem.get())
        }
    }

    fun findItemById(shoppingCardId: Long, productId: Long): CardItem {
        val cardItemEntity = cardItemRepository.findByCardIdAndProductId(shoppingCardId, productId)
        if (cardItemEntity.isPresent) return CardItemMapper.mapToDomain(cardItemEntity.get())
        else throw NoSuchElementException("Card with id id $shoppingCardId and $productId not found")
    }

}