package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.rest.controller.dto.OrderDto

object OrderMapper {

    fun mapToDto(order: Order): OrderDto {
        return OrderDto(
            order.id,
            order.status
        )
    }

    fun mapToDomain(orderDto: OrderDto): Order {
        return Order(
            orderDto.id,
            orderDto.status ?: -1,
            // TODO : INFLATE THE LIST?
            listOf()
        )
    }

}