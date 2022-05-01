package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.rest.controller.dto.OrderDto
import java.time.ZonedDateTime

object OrderMapper {

    fun mapToDto(order: Order): OrderDto {
        return OrderDto(
            id = order.id,
            status = order.status,
            userId = order.userId,
            dateAdded = order.dateAdded,
            orderProducts = order.orderProducts.map(ProductOrderMapper::mapToDto)
        )
    }

    fun mapToDomain(orderDto: OrderDto): Order {
        return Order(
            orderDto.id ?: 0,
            userId = orderDto.userId!!,
            totalPrice = orderDto.totalPrice,
            receiverAddress = orderDto.receiverAddress,
            receiverFullName = orderDto.receiverFullName,
            status = orderDto.status ?: -1,
            orderProducts = orderDto.orderProducts!!.map(ProductOrderMapper::mapToDomain),
            dateAdded = orderDto.dateAdded ?: ZonedDateTime.now().minusMonths(2)
        )
    }

}