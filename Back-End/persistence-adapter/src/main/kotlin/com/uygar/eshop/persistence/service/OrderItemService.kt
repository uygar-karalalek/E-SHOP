package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.OrderProduct
import com.uygar.eshop.persistence.entities.mapper.OrderProductMapper
import com.uygar.eshop.persistence.repositories.OrderProductRepository

class OrderItemService(private val orderProductRepository: OrderProductRepository) {

    fun getAllOrderItems(): List<OrderProduct> {
        return orderProductRepository.findAll().map(OrderProductMapper::mapToDomain)
    }

    fun addItem(orderProduct: OrderProduct) {
        val searchedCardItem = orderProductRepository.findByOrderIdAndProductId(orderProduct.orderId, orderProduct.productId)
        orderProductRepository.save(OrderProductMapper.mapToEntity(orderProduct))
    }

    fun findItemById(orderId: Long, productId: Long): OrderProduct {
        val orderProductEntity = orderProductRepository.findByOrderIdAndProductId(orderId, productId)
        if (orderProductEntity.isPresent) return OrderProductMapper.mapToDomain(orderProductEntity.get())
        else throw NoSuchElementException("Product with id id $orderId and $productId not found")
    }

}