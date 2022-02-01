package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.rest.controller.dto.CardItemDto

object CardItemMapper {

    fun mapToDto(cardItem: CardItem): CardItemDto {
        return CardItemDto(
            cardItem.cardId,
            cardItem.productId,
            cardItem.quantity,
            cardItem.dateAdded
        )
    }

    fun mapToDomain(cardItemDto: CardItemDto): CardItem {
        return CardItem(
            cardItemDto.cardId,
            cardItemDto.productId,
            cardItemDto.quantity,
            cardItemDto.dateAdded
        )
    }

}