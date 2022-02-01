package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.keys.CardItemKey
import com.uygar.eshop.core.CardItem as CardItemDomain

object CardItemMapper {

    fun mapToEntity(cardItem: CardItemDomain): CardItem {
        return CardItem(
            id = CardItemKey(cardItem.cardId, cardItem.productId),
            product = Product(cardItem.productId),
            dateAdded = cardItem.dateAdded,
            quantity = cardItem.quantity
        )
    }

    fun mapToDomain(cardItemEntity: CardItem): CardItemDomain {
        return CardItemDomain(
            cardItemEntity.id.cardId,
            cardItemEntity.id.productId,
            cardItemEntity.quantity,
            cardItemEntity.dateAdded
        )
    }

}