package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.rest.controller.dto.OrderDto
import com.uygar.eshop.rest.controller.dto.OrderWithItemsDto
import kotlin.streams.toList

object OrderMapper {

    fun mapToDto(order: Order): OrderDto {
        return OrderDto(
            order.id,
            order.status
        )
    }

    fun mapWriteToDomain(orderWithItemsDto: OrderWithItemsDto): Order {
        return Order(
            orderWithItemsDto.id,
            orderWithItemsDto.status!!,
            orderWithItemsDto.orderProducts.stream()
                .map(ProductOrderMapper::mapToDomain).toList()
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