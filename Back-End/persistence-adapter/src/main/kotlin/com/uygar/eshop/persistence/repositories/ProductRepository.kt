package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.Product

interface ProductRepository {
    fun findAll(): List<Product>
}