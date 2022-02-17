package com.uygar.eshop.rest.controller

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.service.CardItemService
import com.uygar.eshop.rest.controller.dto.CardItemDto
import com.uygar.eshop.rest.controller.dto.mapper.CardItemMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/card/{cardId}/products")
@RestController
class CardItemController {

    @Autowired
    private lateinit var cardItemService: CardItemService

    @GetMapping
    fun getAllCardProducts(@PathVariable cardId: Long): List<CardItem> {
        return cardItemService.getAllCardItems()
    }

    @PostMapping("/add")
    fun insertProductToCard(@RequestBody cardItemDto: CardItemDto) {
        cardItemService.addItem(CardItemMapper.mapToDomain(cardItemDto))
    }

    @PostMapping("/remove")
    fun removeProductFromCard(@RequestBody cardItemDto: CardItemDto) {
        cardItemService.removeItem(CardItemMapper.mapToDomain(cardItemDto))
    }

}