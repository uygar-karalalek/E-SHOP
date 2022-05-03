package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.persistence.entities.Order
import com.uygar.eshop.persistence.entities.User
import com.uygar.eshop.core.Order as OrderDomain

object OrderMapper {

    fun mapToEntity(order: OrderDomain): Order {
        return Order(
            order.id,
            User(
                id = order.userId,
                name = "",
                address = "",
                email = "",
                surname = "",
                password = "",
                guest = false
            ),
            totalPrice = order.totalPrice!!,
            receiverAddress = order.receiverAddress!!,
            receiverFullName = order.receiverFullName!!,
            status = order.status,
            orderProducts = order.orderProducts.map(OrderProductMapper::mapToEntity),
            dateAdded = order.dateAdded
        )
    }

    fun mapToDomain(orderEntity: Order): OrderDomain {
        return OrderDomain(
            orderEntity.id,
            status = orderEntity.status,
            userId = orderEntity.user.id,
            totalPrice = orderEntity.totalPrice,
            receiverFullName = orderEntity.receiverFullName,
            receiverAddress = orderEntity.receiverAddress,
            orderProducts = orderEntity.orderProducts.map(OrderProductMapper::mapToDomain),
            dateAdded = orderEntity.dateAdded
        )
    }

}