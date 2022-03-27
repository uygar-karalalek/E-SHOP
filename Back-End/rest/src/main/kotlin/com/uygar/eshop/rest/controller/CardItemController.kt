package com.uygar.eshop.rest.controller

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.service.CardItemService
import com.uygar.eshop.rest.controller.dto.CardItemDto
import com.uygar.eshop.rest.controller.dto.mapper.CardItemMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/card")
@RestController
class CardItemController {

    @Autowired
    private lateinit var cardItemService: CardItemService

    @GetMapping("/products")
    fun getAllCardProducts(): List<CardItem> {
        return cardItemService.getAllCardItems()
    }

    @PostMapping("/addProduct")
    fun insertProductToCard(@RequestBody cardItemDto: CardItemDto) {
        cardItemService.addItem(CardItemMapper.mapToDomain(cardItemDto))
    }

    @PostMapping("/{cardId}/addProduct/{productId}")
    fun insertExistingProductToCard(@PathVariable cardId: Long, @PathVariable productId: Long) {
        cardItemService.insertItemByIds(cardId, productId)
    }

    @PostMapping("/{cardId}/removeProduct/{productId}")
    fun removeProductFromCard(@PathVariable cardId: Long,
                              @PathVariable productId: Long) {
        cardItemService.removeItemByIds(cardId, productId)
    }

}