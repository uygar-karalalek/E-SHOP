package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.OrderProduct
import com.uygar.eshop.persistence.entities.mapper.OrderProductMapper
import com.uygar.eshop.persistence.repositories.OrderProductRepository

class OrderProductService(private val orderProductRepository: OrderProductRepository) {

    fun getOrderProductsById(id: Long): List<OrderProduct>  {
        return orderProductRepository.findByOrderId(id).map(OrderProductMapper::mapToDomain)
    }

    fun addItem(orderProduct: OrderProduct) {
        orderProductRepository.save(OrderProductMapper.mapToEntity(orderProduct))
    }

}