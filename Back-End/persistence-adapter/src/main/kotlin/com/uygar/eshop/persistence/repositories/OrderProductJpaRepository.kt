package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.persistence.keys.OrderProductKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.*
import javax.transaction.Transactional

interface OrderProductJpaRepository : JpaRepository<OrderProduct, OrderProductKey>, OrderProductRepository {
    @Query(
        value = "SELECT * FROM `e-shop`.order_product WHERE fk_order=:orderId AND fk_product=:productId",
        nativeQuery = true
    )
    override fun findByOrderIdAndProductId(orderId: Long, productId: Long): Optional<OrderProduct>

    @Transactional
    @Modifying
    @Query(
        value = "UPDATE `e-shop`.order_product SET quantity = quantity+:quantity WHERE fk_order=:orderId AND fk_product=:productId",
        nativeQuery = true
    )
    override fun incrementProductQuantity(orderId: Long, productId: Long, quantity: Int)

}