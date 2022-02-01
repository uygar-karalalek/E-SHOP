package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.CardItem
import org.springframework.data.jpa.repository.JpaRepository

interface CardItemJpaRepository : JpaRepository<CardItem, Long>, CardItemRepository {
}