package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.core.Product
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductMapper {

    fun mapToEntity(product: Product): ProductDto {
        return ProductDto(
            product.id,
            product.description,
            product.price,
            product.title,
            product.cardItems.map(CardItemMapper::mapToEntity),
            product.productOrders.map(ProductOrderMapper::mapToEntity)
        )
    }

    fun mapToDomain(productDto: ProductDto): Product {
        return Product(
            productDto.id,
            productDto.title!!,
            productDto.price!!,
            productDto.description!!,
            productDto.cardItems.map(CardItemMapper::mapToDomain),
            productDto.productOrders.map(ProductOrderMapper::mapToDomain)
        )
    }

}