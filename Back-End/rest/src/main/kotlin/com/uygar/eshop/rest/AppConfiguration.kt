package com.uygar.eshop.rest

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.*
import org.springframework.web.servlet.resource.PathResourceResolver

@Configuration
class AppConfiguration : WebMvcConfigurer {

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