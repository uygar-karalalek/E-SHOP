package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.persistence.keys.OrderProductKey
import com.uygar.eshop.rest.controller.dto.OrderProductDto
import java.time.ZonedDateTime
import com.uygar.eshop.core.OrderProduct as ProductOrderDomain
import com.uygar.eshop.persistence.entities.Product as ProductEntity

object ProductOrderMapper {

    fun mapToEntity(productOrderDomain: ProductOrderDomain): OrderProduct {
        return OrderProduct(
            OrderProductKey(productOrderDomain.orderId, productOrderDomain.productId),
            ProductEntity(
                productOrderDomain.productId,
                productOrderDomain.productTitle,
                productOrderDomain.productPrice
            ),
            productOrderDomain.quantity
        )
    }

    fun mapToDto(productOrderDomain: ProductOrderDomain): OrderProductDto {
        return OrderProductDto(
            productOrderDomain.orderId,
            productOrderDomain.productPrice,
            productOrderDomain.productTitle,
            productOrderDomain.productId,
            productOrderDomain.quantity,
            ZonedDateTime.now()
        )
    }

    fun mapToDomain(orderProductDto: OrderProductDto): ProductOrderDomain {
        return ProductOrderDomain(
            orderProductDto.orderId,
            orderProductDto.productPrice,
            orderProductDto.productTitle,
            orderProductDto.productId,
            orderProductDto.quantity
        )
    }

}