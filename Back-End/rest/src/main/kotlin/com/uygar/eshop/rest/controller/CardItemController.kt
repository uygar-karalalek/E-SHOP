package com.uygar.eshop.rest.controller

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.service.CardItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@RequestMapping("/card/{cardId}/products")
@RestController
class CardItemController {

    @Autowired
    private lateinit var cardItemService: CardItemService

    @GetMapping
    fun getAllCardProducts(@PathVariable cardId: Long): List<CardItem> {
        return cardItemService.getAllProducts()
    }

    @PostMapping("/add/{productId}")
    fun insertProductToCard(@PathVariable cardId: Long, @PathVariable productId: Long) {
        cardItemService.addItem(CardItem(cardId, productId, 1, ZonedDateTime.now()))
    }

}