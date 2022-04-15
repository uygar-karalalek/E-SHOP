package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.OrderProduct
import java.util.*
import kotlin.collections.List as KotlinList

interface OrderProductRepository {
    fun findByOrderIdAndProductId(orderId: Long, productId: Long): Optional<OrderProduct>
    fun findByOrderId(orderId: Long): KotlinList<OrderProduct>
    fun findAll(): KotlinList<OrderProduct>
    fun save(orderProduct: OrderProduct)
    fun incrementProductQuantity(orderId: Long, productId: Long, quantity: Int)
}