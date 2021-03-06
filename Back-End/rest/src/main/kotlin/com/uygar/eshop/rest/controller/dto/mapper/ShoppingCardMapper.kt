package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.rest.controller.dto.ShoppingCardDto

object ShoppingCardMapper {

    fun mapToDto(shoppingCard: ShoppingCard): ShoppingCardDto {
        return ShoppingCardDto(
            shoppingCard.userId
        )
    }

    fun mapToDomain(shoppingCardDto: ShoppingCardDto): ShoppingCard {
        return ShoppingCard(shoppingCardDto.userId, listOf())
    }

}