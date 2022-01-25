package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ProductOrder
import com.uygar.eshop.rest.controller.dto.ProductOrderDto

object ProductOrderMapper {

    fun mapToDto(productOrder: ProductOrder): ProductOrderDto {
        return ProductOrderDto(
            productOrder.id,
            ProductMapper.mapToDto(productOrder.product),
            OrderMapper.mapToDto(productOrder.order),
        )
    }

    fun mapToDomain(productOrderDto: ProductOrderDto): ProductOrder {
        return ProductOrder(
            productOrderDto.id,
            ProductMapper.mapToDomain(productOrderDto.product),
            OrderMapper.mapToDomain(productOrderDto.order)
        )
    }

}