package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.ProductOrder
import com.uygar.eshop.rest.controller.dto.OrderProductDtoRead
import com.uygar.eshop.rest.controller.dto.OrderProductDtoWrite
import com.uygar.eshop.rest.controller.dto.ProductDto

object ProductOrderMapper {

    fun mapToDto(productOrder: ProductOrder): OrderProductDtoRead {
        return OrderProductDtoRead(
            ProductDto(
                productOrder.productId,
                productOrder.productPrice, productOrder.productTitle
            ),
            productOrder.quantity
        )
    }

    fun mapToDomain(orderProduct: OrderProductDtoWrite): ProductOrder {
        return ProductOrder(
            orderId = orderProduct.orderId,
            productId = orderProduct.product.id,
            productTitle = orderProduct.product.title!!,
            productPrice = orderProduct.product.price!!,
            quantity = orderProduct.quantity
        )
    }

}