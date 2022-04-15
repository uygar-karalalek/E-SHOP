package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.persistence.entities.mapper.OrderProductMapper
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
            orderDto.status ?: -1,
            orderDto.userId!!,
            orderDto.orderProducts!!.map(ProductOrderMapper::mapToDomain),
            orderDto.dateAdded ?: ZonedDateTime.now().minusMonths(2)
        )
    }

}