package com.uygar.eshop.persistence.service.unit.service

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.mapper.CardItemMapper
import com.uygar.eshop.persistence.keys.CardItemKey
import com.uygar.eshop.persistence.repositories.CardItemRepository
import com.uygar.eshop.persistence.service.CardItemService
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.time.ZonedDateTime
import java.util.*
import kotlin.NoSuchElementException
import com.uygar.eshop.persistence.entities.CardItem as CardItemEntity

@ExtendWith(MockKExtension::class)
class CardItemServiceTest {

    @MockK
    private lateinit var cardItemRepository: CardItemRepository

    private lateinit var underTest: CardItemService

    @BeforeEach
    fun initialize() {
        underTest = CardItemService(cardItemRepository)
    }

    @Test
    fun cardItemAdded() {
        val dateAdded = ZonedDateTime.now()

        every { cardItemRepository.save(any()) } returns Unit
        every { cardItemRepository.findByCardIdAndProductId(any(), any()) } returns Optional.ofNullable(null)

        underTest.addItem(CardItem(cardId = 1, productPrice = 12.0, "title", productId = 1, 90, dateAdded))

        verify {
            cardItemRepository.save(
                CardItemEntity(
                    CardItemKey(1, 1), Product(1, "title", 12.0), 90,
                    dateAdded
                )
            )
        }
    }

    @Test
    fun allShoppingCardFound() {
        val dateAdded = ZonedDateTime.now()
        every { cardItemRepository.findAll() } returns listOf(
            CardItemEntity(
                CardItemKey(1, 1),
                Product(1, "title1", 12.9),
                quantity = 5,
                dateAdded
            ),
            CardItemEntity(
                CardItemKey(2, 2),
                Product(5, "title2", 13.9),
                quantity = 9,
                dateAdded
            )
        )

        val result = underTest.getAllCardItems()

        MatcherAssert.assertThat(
            result, Matchers.hasItems(
                CardItem(
                    cardId = 2,
                    productId = 2,
                    productPrice = 13.9,
                    productTitle= "title2",
                    quantity = 9,
                    dateAdded = dateAdded
                ),
                CardItem(
                    cardId = 1,
                    productId = 1,
                    productPrice = 12.9,
                    productTitle= "title1",
                    quantity = 5,
                    dateAdded = dateAdded
                )
            )
        )
    }

    @Test
    fun shoppingCardNotFound() {
        every { cardItemRepository.findAll() } returns listOf()

        val result = underTest.getAllCardItems()

        MatcherAssert.assertThat(result.size, Matchers.`is`(0))
    }

    @Test
    fun shoppingCardByIdFound() {
        val dateAdded = ZonedDateTime.now()
        every { cardItemRepository.findByCardIdAndProductId(1, 1) } returns Optional.of(
            CardItemEntity(
                CardItemKey(1, 1),
                Product(1, "title", 12.8),
                quantity = 5,
                dateAdded = dateAdded
            )
        )

        val result = underTest.findItemById(1, 1)

        MatcherAssert.assertThat(
            result, Matchers.`is`(
                CardItem(
                    cardId = 1,
                    productId = 1,
                    productPrice = 12.8,
                    productTitle = "title",
                    quantity = 5,
                    dateAdded = dateAdded
                )
            )
        )
    }

    @Test
    fun shoppingCardWithIdNotFound() {
        every { cardItemRepository.findByCardIdAndProductId(1, 1) } returns Optional.ofNullable(null)
        assertThrows<NoSuchElementException>(message = "Card with id id 1 not found") { underTest.findItemById(1, 1) }
    }

}