package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.core.Product
import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.persistence.keys.OrderProductKey
import com.uygar.eshop.core.OrderProduct as ProductOrderDomain

object ProductOrderMapper {

    fun mapToEntity(productOrderDomain: ProductOrderDomain): OrderProduct {
        return OrderProduct(
            OrderProductKey(productOrderDomain.orderId, productOrderDomain.productId),
            ProductMapper.mapToEntity(
                Product(
                    productOrderDomain.productId,
                    productOrderDomain.productTitle,
                    productOrderDomain.productPrice
                )
            ),
            productOrderDomain.quantity
        )
    }

    fun mapToDomain(orderProductEntity: OrderProduct): ProductOrderDomain {
        return ProductOrderDomain(
            orderProductEntity.id.orderId,
            orderProductEntity.product.price,
            orderProductEntity.product.title,
            orderProductEntity.product.id,
            orderProductEntity.quantity
        )
    }

}