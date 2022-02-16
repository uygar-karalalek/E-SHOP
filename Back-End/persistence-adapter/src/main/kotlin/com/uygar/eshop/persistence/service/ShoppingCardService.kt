package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.Product
import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.persistence.entities.mapper.ShoppingCardMapper
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import java.time.ZonedDateTime

class ShoppingCardService(private val shoppingCardRepository: ShoppingCardRepository) {

    fun getAllCards(): List<ShoppingCard> {
        return shoppingCardRepository.findAll().map(ShoppingCardMapper::mapToDomain)
    }

    fun getCardById(id: Long): ShoppingCard {
        val shoppingCard = shoppingCardRepository.findById(id)
        if (shoppingCard.isPresent) return ShoppingCardMapper.mapToDomain(shoppingCard.get())
        else throw NoSuchElementException("Card with id id $id not found")
    }

    fun save(shoppingCard: ShoppingCard) {
        shoppingCardRepository.save(ShoppingCardMapper.mapToEntity(shoppingCard))
    }

    fun insertProductById(id: Long, product: Product) {
//        val cardItemToAdd = CardItem(
//            null,
//            ZonedDateTime.now(),
//
//        )
//        save(shoppingCardRepository.findById(id).also { it.cardItems.add() })
    }

}