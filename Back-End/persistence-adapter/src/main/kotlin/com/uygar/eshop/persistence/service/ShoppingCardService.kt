package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.persistence.entities.mapper.ShoppingCardMapper
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import com.uygar.eshop.persistence.entities.ShoppingCard as ShoppingCardEntity

class ShoppingCardService(private val shoppingCardRepository: ShoppingCardRepository) {

    fun getAllCards(): List<ShoppingCard> {
        return shoppingCardRepository.findAll().map(ShoppingCardMapper::mapToDomain)
    }



    fun getCardById(id: Long): ShoppingCard {
        val shoppingCard = shoppingCardRepository.findById(id)
        if (shoppingCard.isPresent) return ShoppingCardMapper.mapToDomain(shoppingCard.get())
        else throw NoSuchElementException("Card with id id $id not found")
    }

    fun saveCard(shoppingCard: ShoppingCard): ShoppingCard? {
        val card: ShoppingCardEntity = ShoppingCardMapper.mapToEntity(shoppingCard)
        shoppingCardRepository.save(card)
        return shoppingCardRepository.findAll().map(ShoppingCardMapper::mapToDomain)
            .maxByOrNull(ShoppingCard::userId)
    }

}