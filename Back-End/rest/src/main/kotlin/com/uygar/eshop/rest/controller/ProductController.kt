package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.User
import com.uygar.eshop.persistence.service.ProductService
import com.uygar.eshop.persistence.service.UserService
import com.uygar.eshop.rest.controller.dto.ProductDto
import com.uygar.eshop.rest.controller.dto.mapper.ProductMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/products")
@RestController
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping
    fun getProducts(): List<ProductDto> {
        return productService.getAllProducts().map(ProductMapper::mapToDto)
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Long): ProductDto {
        return ProductMapper.mapToDto(productService.getAllProducts().first { it.id == productId })
    }

}