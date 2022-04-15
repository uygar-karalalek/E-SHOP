package com.uygar.eshop.rest.controller

import com.uygar.eshop.persistence.service.OrderProductService
import com.uygar.eshop.rest.controller.dto.OrderProductDto
import com.uygar.eshop.rest.controller.dto.mapper.ProductOrderMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders/{orderId}")
@RestController
class ProductOrderController {

    @Autowired
    private lateinit var orderProductService: OrderProductService

    @GetMapping("/products")
    fun getOrderProductsById(@PathVariable orderId: Long): List<OrderProductDto> {
        return orderProductService.getOrderProductsById(orderId).map(ProductOrderMapper::mapToDto)
    }

}