package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository

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
        save(shoppingCardRepository.findById(id).also {

        })
        shoppingCardRepository.saveProductById(id, product)
    }

}