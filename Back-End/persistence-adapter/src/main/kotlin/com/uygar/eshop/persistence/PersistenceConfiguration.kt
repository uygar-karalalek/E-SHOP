package com.uygar.eshop.persistence

import com.uygar.eshop.persistence.repositories.ProductRepository
import com.uygar.eshop.persistence.repositories.ShoppingCardRepository
import com.uygar.eshop.persistence.repositories.UserRepository
import com.uygar.eshop.persistence.service.ProductService
import com.uygar.eshop.persistence.service.ShoppingCardService
import com.uygar.eshop.persistence.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PersistenceConfiguration {

    @Bean
    open fun userService(userRepo: UserRepository): UserService {
        return UserService(userRepo)
    }

    @Bean
    open fun productService(productRepository: ProductRepository): ProductService {
        return ProductService(productRepository)
    }

    @Bean
    open fun shoppingCardService(shoppingCardRepository: ShoppingCardRepository): ShoppingCardService {
        return ShoppingCardService(shoppingCardRepository)
    }

}