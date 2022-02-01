package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.rest.controller.dto.ShoppingCardDto

object ShoppingCardMapper {

    fun mapToDto(shoppingCard: ShoppingCard): ShoppingCardDto {
        return ShoppingCardDto(
            shoppingCard.id,
            shoppingCard.cardItems.map(CardItemMapper::mapToDto)
        )
    }

    fun mapToDomain(shoppingCardDto: ShoppingCardDto): ShoppingCard {
        return ShoppingCard(
            shoppingCardDto.id,
            shoppingCardDto.cardItems.map(CardItemMapper::mapToDomain)
        )
    }

}