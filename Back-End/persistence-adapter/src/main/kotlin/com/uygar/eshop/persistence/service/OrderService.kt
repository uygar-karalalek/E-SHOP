package com.uygar.eshop.persistence.service

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.entities.Order
import com.uygar.eshop.persistence.entities.mapper.OrderMapper
import com.uygar.eshop.persistence.entities.mapper.OrderProductMapper
import com.uygar.eshop.persistence.repositories.OrderRepository
import com.uygar.eshop.core.Order as OrderDomain

class OrderService(private val orderRepository: OrderRepository,
                   private val cardItemService: CardItemService, private val orderItemService: OrderItemService) {

    fun getAllOrders(): List<OrderDomain> {
        return orderRepository.findAll().map(OrderMapper::mapToDomain)
    }

    fun insertOrder(order: OrderDomain) {
        val savedOrder: Order = orderRepository.saveAndFlush(OrderMapper.mapToEntity(order))

        val items: List<CardItem> = cardItemService.getAllCardItems()
        items.forEach { cardItemService.removeAllItemsById(it.cardId, it.productId) }
        items.map { OrderProductMapper.mapFromDomainCardItem(savedOrder.id, it) }
            .forEach(orderItemService::addItem)
    }

}