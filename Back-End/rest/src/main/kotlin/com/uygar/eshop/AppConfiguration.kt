package com.uygar.eshop

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    fun swaggerConfiguration(): OpenAPI {
        return OpenAPI().info(
            Info()
                .title("Test")
                .description("APIs of Hospit Home application")
                .version("v0.0.1")
        )
    }

}