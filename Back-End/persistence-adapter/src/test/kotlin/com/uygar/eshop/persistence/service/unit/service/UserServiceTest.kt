package com.uygar.eshop.persistence.service.unit.service

import com.uygar.eshop.core.CardItem
import com.uygar.eshop.core.ShoppingCard
import com.uygar.eshop.core.User
import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.keys.CardItemKey
import com.uygar.eshop.persistence.repositories.UserRepository
import com.uygar.eshop.persistence.service.UserService
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
import com.uygar.eshop.persistence.entities.CardItem as CardItemEntity
import com.uygar.eshop.persistence.entities.ShoppingCard as ShoppingCardEntity
import com.uygar.eshop.persistence.entities.User as UserEntity

@ExtendWith(MockKExtension::class)
class UserServiceTest {

    @MockK
    private lateinit var userRepository: UserRepository

    private lateinit var underTest: UserService

    @BeforeEach
    fun initialize() {
        underTest = UserService(userRepository)
    }

    @Test
    fun repositoryFindsAllUsers() {
        val dateAdded = ZonedDateTime.now()
        every { userRepository.findAll() }.returns(
            listOf(
                UserEntity(
                    1,
                    "Uygar",
                    "Karalalek",
                    "Via XXX",
                    "karalalek@gmail.com",
                    "password",
                    ShoppingCardEntity(
                        1, mutableListOf(
                            CardItemEntity(
                                CardItemKey(1, 1),
                                Product(1, "Title", 90.0, "Description"),
                                quantity = 3,
                                dateAdded
                            )
                        )
                    )
                )
            )
        )

        val result = underTest.getAllUsers()

        verify { userRepository.findAll() }

        MatcherAssert.assertThat(result, Matchers.`is`(
            listOf(
                User(
                    1,
                    "Uygar",
                    "Karalalek",
                    "Via XXX",
                    "karalalek@gmail.com",
                    "password",
                    ShoppingCard(
                        1, mutableListOf(
                            CardItem(
                                cardId = 1,
                                productId = 1,
                                quantity = 3,
                                productPrice = 90.0,
                                productTitle = "Title",
                                dateAdded = dateAdded
                            )
                        )
                    )
                )
            )
        ))
    }

    @Test
    fun repositoryDoNotFindAllUsers() {
        every { userRepository.findAll() }.returns(listOf())

        val result = underTest.getAllUsers()

        verify { userRepository.findAll() }

        MatcherAssert.assertThat(result.size, Matchers.`is`(0))
    }

    @Test
    fun userIsDeleted() {
        every { userRepository.deleteById(1) } returns Unit

        underTest.deleteUserById(1)

        verify { userRepository.deleteById(any()) }
    }

    @Test
    fun userIsNotDeleted() {
        every { userRepository.deleteById(1) } throws NoSuchElementException("Exception")

        assertThrows<NoSuchElementException>(message = "Exception") { underTest.deleteUserById(1) }
    }

}