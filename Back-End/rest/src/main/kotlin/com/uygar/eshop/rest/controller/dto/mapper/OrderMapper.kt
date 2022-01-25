package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.rest.controller.dto.OrderDto

object OrderMapper {

    fun mapToDto(order: Order): OrderDto {
        return OrderDto(
            order.id,
            order.status,
            order.productOrders.map(ProductOrderMapper::mapToDto)
        )
    }

    fun mapToDomain(orderDto: OrderDto): Order {
        return Order(
            orderDto.id,
            orderDto.status,
            orderDto.productOrders.map(ProductOrderMapper::mapToDomain)
        )
    }

}