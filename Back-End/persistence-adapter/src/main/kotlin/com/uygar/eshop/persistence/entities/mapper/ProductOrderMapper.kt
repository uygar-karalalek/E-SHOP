package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.ProductOrder
import com.uygar.eshop.core.ProductOrder as ProductOrderDomain

object ProductOrderMapper {

    fun mapToEntity(productOrderDomain: ProductOrderDomain): ProductOrder {
        return ProductOrder(
            productOrderDomain.id,
            ProductMapper.mapToEntity(productOrderDomain.product),
            OrderMapper.mapToEntity(productOrderDomain.order),
        )
    }

    fun mapToDomain(productOrderEntity: ProductOrder): ProductOrderDomain {
        return ProductOrderDomain(
            productOrderEntity.id,
            ProductMapper.mapToDomain(productOrderEntity.product),
            OrderMapper.mapToDomain(productOrderEntity.order)
        )
    }

}