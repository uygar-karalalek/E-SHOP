package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.repositories.ProductRepository

class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> {
        return productRepository.findAll().toList()
    }

}