package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.Order

interface OrderRepository {
    fun findById(id: Long): Order
    fun findByUserId(userId: Long): List<Order>
    fun findAll(): List<Order>
    fun save(order: Order)
    fun saveAndFlush(order: Order): Order
}