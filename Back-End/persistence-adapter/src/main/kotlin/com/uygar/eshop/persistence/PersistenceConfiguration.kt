package com.uygar.eshop.persistence

import com.uygar.eshop.persistence.repositories.*
import com.uygar.eshop.persistence.service.*
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

    @Bean
    open fun orderItemService(orderItemRepository: OrderProductRepository): OrderItemService {
        return OrderItemService(orderItemRepository)
    }

    @Bean
    open fun orderService(orderRepository: OrderJpaRepository, cardItemService: CardItemService,
                          orderItemService: OrderItemService): OrderService {
        return OrderService(orderRepository, cardItemService, orderItemService)
    }

}