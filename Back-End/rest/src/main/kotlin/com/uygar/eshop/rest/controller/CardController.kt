package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.ShoppingCardService
import com.uygar.eshop.rest.controller.dto.ShoppingCardDto
import com.uygar.eshop.rest.controller.dto.mapper.ShoppingCardMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/card")
@RestController
class CardController {

    @Autowired
    private lateinit var cardService: ShoppingCardService

    @PostMapping("/add")
    fun saveCard(@RequestBody shoppingCardDto: ShoppingCardDto): ShoppingCardDto {
        val shoppingCard = cardService.saveCard(ShoppingCardMapper.mapToDomain(shoppingCardDto))
            ?: throw java.lang.Exception("Server error")
        return ShoppingCardMapper.mapToDto(shoppingCard)
    }

}