package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.core.ShoppingCard as ShoppingCardDomain

object ShoppingCardMapper {

    fun mapToEntity(shoppingCard: ShoppingCardDomain): ShoppingCard {
        return ShoppingCard(
            shoppingCard.id,
            ArrayList(shoppingCard.cardItems.map(CardItemMapper::mapToEntity))
        )
    }

    fun mapToDomain(shoppingCard: ShoppingCard): ShoppingCardDomain {
        return ShoppingCardDomain(
            shoppingCard.id,
            shoppingCard.cardItems.map(CardItemMapper::mapToDomain)
        )
    }

}