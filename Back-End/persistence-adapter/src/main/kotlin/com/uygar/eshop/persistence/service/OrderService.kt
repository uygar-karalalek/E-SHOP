package com.uygar.eshop.persistence.service

import com.uygar.eshop.persistence.entities.mapper.OrderMapper
import com.uygar.eshop.persistence.repositories.OrderRepository
import com.uygar.eshop.core.Order as OrderDomain

class OrderService(private val orderRepository: OrderRepository) {

    fun getAllOrders(): List<OrderDomain> {
        return orderRepository.findAll().map(OrderMapper::mapToDomain)
    }

    fun insertOrder(order: OrderDomain) {
        orderRepository.save(OrderMapper.mapToEntity(order))
    }

}