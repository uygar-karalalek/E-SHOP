package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ProductOrder
import com.uygar.eshop.rest.controller.dto.OrderProduct

object ProductOrderMapper {

    fun mapToDto(productOrder: ProductOrder): OrderProduct {
        return OrderProduct(
            productOrder.id,
            ProductMapper.mapToDto(productOrder.product),
            OrderMapper.mapToDto(productOrder.order),
            productOrder.quantity
        )
    }

    fun mapToDomain(orderProduct: OrderProduct): ProductOrder {
        return ProductOrder(
            orderProduct.id,
            ProductMapper.mapToDomain(orderProduct.product),
            OrderMapper.mapToDomain(orderProduct.order),
            orderProduct.productQuantity
        )
    }

}