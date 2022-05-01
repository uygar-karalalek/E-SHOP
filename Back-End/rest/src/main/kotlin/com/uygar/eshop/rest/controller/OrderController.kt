package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.OrderService
import com.uygar.eshop.rest.controller.dto.OrderDto
import com.uygar.eshop.rest.controller.dto.mapper.OrderMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/user/{userId}/orders")
@RestController
class OrderController {

    @Autowired
    private lateinit var orderService: OrderService

    @GetMapping
    fun getUserOrderList(@PathVariable userId: Long): List<OrderDto> {
        return orderService.getOrderByUserId(userId).map(OrderMapper::mapToDto)
    }

    @PostMapping("/add")
    fun addOrderToUser(@PathVariable userId: String, @RequestBody order: OrderDto) {
        println(order.receiverAddress)
        println(order.id)
        println(order.dateAdded)
        println(order.receiverFullName)
        return orderService.insertOrder(OrderMapper.mapToDomain(order))
    }

}