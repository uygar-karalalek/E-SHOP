package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.persistence.keys.CardItemKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.*
import javax.transaction.Transactional

interface CardItemJpaRepository : JpaRepository<CardItem, CardItemKey>, CardItemRepository {
    @Query(
        value = "SELECT * FROM `e-shop`.card_item WHERE fk_card=:cardId AND fk_product=:productId",
        nativeQuery = true
    )
    override fun findByCardIdAndProductId(cardId: Long, productId: Long): Optional<CardItem>

    @Transactional
    @Modifying
    @Query(
        value = "UPDATE `e-shop`.card_item SET quantity = quantity+:quantity WHERE fk_card=:cardId AND fk_product=:productId",
        nativeQuery = true
    )
    override fun incrementItemQuantity(cardId: Long, productId: Long, quantity: Int)

    @Transactional
    @Modifying
    @Query(
        value = "DELETE FROM card_item WHERE fk_card=:cardId AND fk_product=:productId",
        nativeQuery = true
    )
    override fun deleteById(cardId: Long, productId: Long)

}