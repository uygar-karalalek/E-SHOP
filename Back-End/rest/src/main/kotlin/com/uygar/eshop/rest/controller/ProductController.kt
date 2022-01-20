package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.User
import com.uygar.eshop.persistence.service.ProductService
import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.ProductDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/products")
@RestController
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping
    fun getProducts(): List<Product> {
        return productService.getAllProducts()
    }

}