package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository

class ShoppingCardService(private val shoppingCardRepository: ShoppingCardRepository) {

    fun getAllCards(): List<ShoppingCard> {
        return shoppingCardRepository.findAll().toList()
    }

    fun insertProduct(card: ShoppingCard) {
        shoppingCardRepository.save(card)
    }

}