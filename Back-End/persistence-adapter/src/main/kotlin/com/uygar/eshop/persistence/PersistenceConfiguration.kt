package com.uygar.eshop.persistence

import com.uygar.eshop.persistence.repositories.*
import com.uygar.eshop.persistence.service.CardItemService
import com.uygar.eshop.persistence.service.ProductService
import com.uygar.eshop.persistence.service.ShoppingCardService
import com.uygar.eshop.persistence.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PersistenceConfiguration {

    @Bean
    open fun userService(userRepo: UserJpaRepository): UserService {
        return UserService(userRepo)
    }

    @Bean
    open fun productService(productRepository: ProductJpaRepository): ProductService {
        return ProductService(productRepository)
    }

    @Bean
    open fun shoppingCardService(shoppingCardRepository: ShoppingCardJpaRepository): ShoppingCardService {
        return ShoppingCardService(shoppingCardRepository)
    }

    @Bean
    open fun cardItemService(cardItemRepository: CardItemJpaRepository): CardItemService {
        return CardItemService(cardItemRepository)
    }

}