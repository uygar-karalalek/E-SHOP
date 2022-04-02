package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.Order
import com.uygar.eshop.rest.controller.dto.OrderDto
import com.uygar.eshop.rest.controller.dto.OrderWithItemsDto
import java.time.ZonedDateTime
import kotlin.streams.toList

object OrderMapper {

    fun mapToDto(order: Order): OrderDto {
        return OrderDto(
            order.id,
            order.status
        )
    }

    fun mapToDomain(orderDto: OrderDto): Order {
        return Order(
            orderDto.id ?: 0,
            orderDto.status ?: -1,
            // TODO : INFLATE THE LIST?
            listOf(),
            ZonedDateTime.now()
        )
    }

}