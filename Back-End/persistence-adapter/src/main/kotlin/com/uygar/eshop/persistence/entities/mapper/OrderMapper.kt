package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.Order
import com.uygar.eshop.core.Order as OrderDomain

object OrderMapper {

    fun mapToEntity(order: OrderDomain): Order {
        return Order(
            order.id,
            order.status,
            order.orderProducts.map(ProductOrderMapper::mapToEntity),
            order.dateAdded
        )
    }

    fun mapToDomain(orderEntity: Order): OrderDomain {
        return OrderDomain(
            orderEntity.id,
            orderEntity.status,
            orderEntity.orderProducts.map(ProductOrderMapper::mapToDomain),
            orderEntity.dateAdded
        )
    }

}