package com.uygar.eshop.persistence.service.unit.service

import com.uygar.eshop.persistence.entities.CardItem
import com.uygar.eshop.persistence.entities.ShoppingCard
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import com.uygar.eshop.persistence.service.ShoppingCardService
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ShoppingCardServiceTest {

    @MockK
    private lateinit var shoppingCardRepository: ShoppingCardRepository

    private lateinit var underTest: ShoppingCardService

    @BeforeAll
    fun initialize() {
        underTest = ShoppingCardService(shoppingCardRepository)
    }

    @Test
    fun shoppingCardAdded() {
        every { shoppingCardRepository.save(any()) } returns Unit
        underTest.save(ShoppingCard(1, mutableListOf()))
        //verify { shoppingCardRepository.save(ShoppingCard(1l, listOf<CardItem>())) }
    }

}