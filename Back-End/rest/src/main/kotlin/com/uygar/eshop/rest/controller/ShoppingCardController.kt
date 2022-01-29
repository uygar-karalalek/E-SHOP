package com.uygar.eshop.rest.controller

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.core.Product
import com.uygar.eshop.persistence.service.ShoppingCardService
import com.uygar.eshop.rest.controller.dto.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@RequestMapping("/cards")
@RestController
class ShoppingCardController {

    @Autowired
    private lateinit var shoppingCardService: ShoppingCardService

    @PostMapping("/{cardId}")
    fun insertProduct(@PathVariable cardId: Long, @RequestBody product: ProductDto) {
//        val cardItem = CardItem(
//            -1L,
//            ZonedDateTime.now(),
//
//        )
//        shoppingCardService.insertProductById(cardId, product)
    }

    @GetMapping("/{cardId}")
    fun getCardProducts(@PathVariable cardId: Long): List<Product> {
//        return shoppingCardService.getAllCards().map()
        return arrayListOf()
    }

}