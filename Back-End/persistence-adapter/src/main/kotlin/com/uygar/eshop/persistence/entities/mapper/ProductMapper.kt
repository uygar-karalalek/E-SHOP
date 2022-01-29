package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.core.Product as ProductDomain

object ProductMapper {

    fun mapToEntity(product: ProductDomain): Product {
        return Product(
            product.id,
            product.description,
            product.price,
            product.title
        )
    }

    fun mapToDomain(productDto: Product): ProductDomain {
        return ProductDomain(
            productDto.id,
            productDto.title,
            productDto.price,
            productDto.description,
        )
    }

}