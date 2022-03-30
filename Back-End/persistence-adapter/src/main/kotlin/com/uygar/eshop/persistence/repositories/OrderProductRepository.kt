package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.OrderProduct
import java.util.*

interface OrderProductRepository {
    fun findByOrderIdAndProductId(orderId: Long, productId: Long): Optional<OrderProduct>
    fun findAll(): List<OrderProduct>
    fun save(orderProduct: OrderProduct)
    fun incrementProductQuantity(orderId: Long, productId: Long, quantity: Int)
}