package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.User
import com.uygar.eshop.persistence.service.ProductService
import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/cards")
@RestController
class CardController {

    @Autowired
    private lateinit var productService: ProductService

    @PostMapping("/{cardId}")
    fun insertProduct(@PathVariable cardId: Long, @RequestBody product: Product) {
    }

}