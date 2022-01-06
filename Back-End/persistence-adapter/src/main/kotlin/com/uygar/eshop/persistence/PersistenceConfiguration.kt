package com.uygar.eshop.persistence

import com.uygar.eshop.persistence.repositories.UserRepository
import com.uygar.eshop.persistence.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PersistenceConfiguration {

    @Bean
    open fun userService(userRepo: UserRepository): UserService {
        return UserService(userRepo)
    }

}