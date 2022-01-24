package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductMapper {

    fun mapToDto(product: Product): ProductDto {
        return ProductDto(
            product.id,
            product.description,
            product.price,
            product.title,
            product.productsInCard,
            product.productOrders
        )
    }

    fun mapToDomain(productDto: ProductDto): Product {
        return Product(
            productDto.id,
            productDto.title!!,
            productDto.price!!,
            productDto.description!!,
            productDto.productOrders,
            productDto.productsInCard
        )
    }

}