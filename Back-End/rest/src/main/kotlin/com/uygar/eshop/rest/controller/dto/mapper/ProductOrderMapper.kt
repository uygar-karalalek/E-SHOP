package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.OrderProduct
import com.uygar.eshop.rest.controller.dto.OrderProductDtoRead
import com.uygar.eshop.rest.controller.dto.OrderProductDtoWrite
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductOrderMapper {

    fun mapToDto(orderProduct: OrderProduct): OrderProductDtoRead {
        return OrderProductDtoRead(
            ProductDto(
                orderProduct.productId,
                orderProduct.productPrice, orderProduct.productTitle
            ),
            orderProduct.quantity
        )
    }

    fun mapToDomain(orderProduct: OrderProductDtoWrite): OrderProduct {
        return OrderProduct(
            orderId = orderProduct.orderId,
            productId = orderProduct.product.id,
            productTitle = orderProduct.product.title!!,
            productPrice = orderProduct.product.price!!,
            quantity = orderProduct.quantity
        )
    }

}