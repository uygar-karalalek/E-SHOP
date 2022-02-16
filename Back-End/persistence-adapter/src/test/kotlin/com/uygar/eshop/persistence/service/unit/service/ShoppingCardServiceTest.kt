package com.uygar.eshop.persistence.service.unit.service

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.keys.CardItemKey
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import com.uygar.eshop.persistence.service.ShoppingCardService
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.ZonedDateTime
import java.util.*
import com.uygar.eshop.persistence.entities.CardItem as CardItemEntity
import com.uygar.eshop.persistence.entities.ShoppingCard as ShoppingCardEntity

@ExtendWith(MockKExtension::class)
class ShoppingCardServiceTest {

    @MockK
    private lateinit var shoppingCardRepository: ShoppingCardRepository

    private lateinit var underTest: ShoppingCardService

    @BeforeEach
    fun initialize() {
        underTest = ShoppingCardService(shoppingCardRepository)
    }

    @Test
    fun shoppingCardAdded() {
        every { shoppingCardRepository.save(any()) } returns Unit
        underTest.save(ShoppingCard(1, mutableListOf()))

        verify { shoppingCardRepository.save(ShoppingCardEntity(1, arrayListOf())) }
    }

    @Test
    fun allShoppingCardFound() {
        val dateAdded = ZonedDateTime.now()
        every { shoppingCardRepository.findAll() } returns listOf(
            ShoppingCardEntity(
                1,
                mutableListOf(
                    CardItemEntity(
                        CardItemKey(1, 1),
                        Product(1, "title", 12.9, "description"),
                        5,
                        dateAdded
                    )
                )
            ),
            ShoppingCardEntity(
                2,
                mutableListOf(
                    CardItemEntity(
                        CardItemKey(2, 2),
                        Product(5, "title1", 13.9, "description1"),
                        quantity = 9,
                        dateAdded
                    )
                )
            )
        )

        val result = underTest.getAllCards()

        MatcherAssert.assertThat(
            result, Matchers.hasItems(
                ShoppingCard(
                    1,
                    mutableListOf(
                        CardItem(
                            cardId = 1,
                            productPrice = 12.9,
                            productTitle = "title",
                            productId = 1,
                            quantity = 5,
                            dateAdded = dateAdded
                        )
                    )
                ),
                ShoppingCard(
                    2,
                    mutableListOf(
                        CardItem(
                            cardId = 2,
                            productId = 2,
                            productPrice = 13.9,
                            productTitle = "title1",
                            quantity = 9,
                            dateAdded = dateAdded
                        )
                    )
                )
            )
        )
    }

    @Test
    fun shoppingCardNotFound() {
        every { shoppingCardRepository.findAll() } returns listOf()

        val result = underTest.getAllCards()

        MatcherAssert.assertThat(result.size, Matchers.`is`(0))
    }

    @Test
    fun shoppingCardFound() {
        val dateAdded = ZonedDateTime.now()
        every { shoppingCardRepository.findById(1) } returns Optional.of(
            ShoppingCardEntity(
                1,
                mutableListOf(
                    CardItemEntity(
                        CardItemKey(1, 1),
                        Product(1, "title", 12.9, "description"),
                        5,
                        dateAdded
                    )
                )
            )
        )


        val result = underTest.getCardById(1)

        MatcherAssert.assertThat(result, Matchers.`is`(
                ShoppingCard(
                    1,
                    mutableListOf(
                        CardItem(
                            cardId = 1,
                            productPrice = 12.9,
                            productTitle = "title",
                            productId = 1,
                            quantity = 5,
                            dateAdded = dateAdded
                        )
                    )
                )
            )
        )
    }

}