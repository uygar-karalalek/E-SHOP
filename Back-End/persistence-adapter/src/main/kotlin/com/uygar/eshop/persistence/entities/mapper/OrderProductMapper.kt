package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.keys.OrderProductKey
import com.uygar.eshop.core.OrderProduct as OrderProductDomain

object OrderProductMapper {

    fun mapToEntity(orderProduct: OrderProductDomain): OrderProduct {
        return OrderProduct(
            id = OrderProductKey(orderProduct.orderId, orderProduct.productId),
            product = Product(orderProduct.productId, orderProduct.productTitle, orderProduct.productPrice),
            quantity = orderProduct.quantity
        )
    }

    fun mapToDomain(orderProductEntity: OrderProduct): OrderProductDomain {
        return OrderProductDomain(
            orderProductEntity.id.orderId,
            orderProductEntity.product.price,
            orderProductEntity.product.title,
            orderProductEntity.id.productId,
            orderProductEntity.quantity,
        )
    }

    fun mapFromDomainCardItem(orderId: Long, cardItem: CardItem): OrderProductDomain {
        return OrderProductDomain(
            orderId,
            cardItem.productPrice,
            cardItem.productTitle,
            cardItem.productId,
            cardItem.quantity,
        )
    }

}