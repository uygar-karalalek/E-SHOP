package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.mapper.ProductMapper
import com.uygar.eshop.persistence.repositories.ProductRepository
import com.uygar.eshop.core.Product as ProductDomain

class ProductService(private val productRepository: ProductRepository) {

    fun getAllProducts(): List<ProductDomain> {
        return productRepository.findAll().map(ProductMapper::mapToDomain)
    }

    fun insertProduct(product: ProductDomain) {
        productRepository.save(ProductMapper.mapToEntity(product))
    }

}