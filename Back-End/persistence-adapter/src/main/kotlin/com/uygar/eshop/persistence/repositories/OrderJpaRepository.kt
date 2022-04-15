package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.Order
import com.uygar.eshop.persistence.entities.OrderProduct
import com.uygar.eshop.persistence.keys.OrderProductKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface OrderJpaRepository : JpaRepository<Order, Long>, OrderRepository {

    @Query(value = "SELECT * FROM `order` WHERE fk_user=:userId",
        nativeQuery = true)
    override fun findByUserId(userId: Long): List<Order>

}