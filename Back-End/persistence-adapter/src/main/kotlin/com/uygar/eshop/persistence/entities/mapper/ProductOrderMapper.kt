package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.core.ProductOrder as ProductOrderDomain

object ProductOrderMapper {

    fun mapToEntity(productOrderDomain: ProductOrderDomain): OrderProduct {
        return OrderProduct(
            productOrderDomain.id,
            ProductMapper.mapToEntity(productOrderDomain.product),
            productOrderDomain.quantity
        )
    }

    fun mapToDomain(orderProductEntity: OrderProduct): ProductOrderDomain {
        return ProductOrderDomain(
            orderProductEntity.id,
            ProductMapper.mapToDomain(orderProductEntity.product),
            orderProductEntity.product_quantity
        )
    }

}