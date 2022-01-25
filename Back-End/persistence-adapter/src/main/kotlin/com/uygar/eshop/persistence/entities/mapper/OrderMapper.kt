package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.Order
import com.uygar.eshop.core.Order as OrderDomain

object OrderMapper {

    fun mapToEntity(order: OrderDomain): Order {
        return Order(
            order.id,
            order.status,
            order.productOrders.map(ProductOrderMapper::mapToEntity)
        )
    }

    fun mapToDomain(orderEntity: Order): OrderDomain {
        return OrderDomain(
            orderEntity.id,
            orderEntity.status,
            orderEntity.productOrders.map(ProductOrderMapper::mapToDomain)
        )
    }

}