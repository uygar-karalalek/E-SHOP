package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.OrderService
import com.uygar.eshop.rest.controller.dto.OrderDto
import com.uygar.eshop.rest.controller.dto.OrderWithItemsDto
import com.uygar.eshop.rest.controller.dto.mapper.OrderMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user/{userId}/orders")
@RestController
class OrderController {

    @Autowired
    private lateinit var orderService: OrderService

    @Autowired
    private lateinit var orderProductService: OrderService

    @GetMapping
    fun getUserOrderList(@PathVariable userId: String): List<OrderDto> {
        return orderService.getAllOrders().map(OrderMapper::mapToDto)
    }

    @PostMapping("/add")
    fun addOrderToUser(@PathVariable userId: String, @RequestBody order: OrderWithItemsDto) {
        return orderService.insertOrder(OrderMapper.mapWriteToDomain(order))
    }

}