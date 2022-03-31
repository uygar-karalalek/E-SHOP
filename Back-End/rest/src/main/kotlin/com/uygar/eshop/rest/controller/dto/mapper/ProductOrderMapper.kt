package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ProductOrder
import com.uygar.eshop.rest.controller.dto.OrderDto
import com.uygar.eshop.rest.controller.dto.OrderProduct
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductOrderMapper {

    fun mapToDto(productOrder: ProductOrder): OrderProduct {
        return OrderProduct(
            OrderDto(productOrder.orderId),
            ProductDto(
                productOrder.productId,
                productOrder.productPrice, productOrder.productTitle
            ),
            productOrder.quantity
        )
    }

    fun mapToDomain(orderProduct: OrderProduct): ProductOrder {
        return ProductOrder(
            orderId = orderProduct.order.id,
            productId = orderProduct.product.id,
            productTitle = orderProduct.product.title!!,
            productPrice = orderProduct.product.price!!,
            quantity = orderProduct.productQuantity,
        )
    }

}