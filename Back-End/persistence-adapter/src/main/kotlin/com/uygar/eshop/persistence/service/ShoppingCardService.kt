package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.Product
import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.persistence.entities.mapper.ProductMapper
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import java.time.ZonedDateTime

class ShoppingCardService(private val shoppingCardRepository: ShoppingCardRepository) {

    fun getAllCards(): List<ShoppingCard> {
        return shoppingCardRepository.findAll().toList()
    }

    fun getCardById(id: Long): ShoppingCard {
        return shoppingCardRepository.findById(id)
    }

    fun save(shoppingCard: ShoppingCard) {
        shoppingCardRepository.save(shoppingCard)
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