package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.core.CardItem as CardItemDomain

object CardItemMapper {

    fun mapToEntity(cardItem: CardItemDomain): CardItem {
        return CardItem(
            cardItem.id,
            cardItem.dateAdded,
            ShoppingCardMapper.mapToEntity(cardItem.shoppingCard),
            ProductMapper.mapToEntity(cardItem.product),
        )
    }

    fun mapToDomain(cardItemEntity: CardItem): CardItemDomain {
        return CardItemDomain(
            cardItemEntity.id,
            cardItemEntity.dateAdded,
            ShoppingCardMapper.mapToDomain(cardItemEntity.shoppingCard),
            ProductMapper.mapToDomain(cardItemEntity.product)
        )
    }

}