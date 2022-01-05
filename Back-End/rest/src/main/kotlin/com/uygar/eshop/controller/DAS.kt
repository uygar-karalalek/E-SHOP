package com.uygar.eshop.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ciao")
@RestController
class DAS {

    @GetMapping
    fun testFunction(): TestObject {
        return TestObject("Ciao")
    }

    @PostMapping
    fun testFunction1(): TestObject {
        return TestObject("Ciao")
    }

    data class TestObject(val desc: String)

}