package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Product
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductMapper {

    fun mapToDto(product: Product): ProductDto {
        return ProductDto(
            product.id,
            product.description,
            product.price,
            product.title,
            product.cardItems.map(CardItemMapper::mapToDto),
            product.productOrders.map(ProductOrderMapper::mapToDto)
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