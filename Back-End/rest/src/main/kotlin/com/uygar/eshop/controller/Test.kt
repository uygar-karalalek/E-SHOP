package com.uygar.eshop.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Test {

    @GetMapping(name = "other/api")
    fun testFunction(): TestObject {
        return TestObject("Ciao")
    }

    @PostMapping(name = "other/api")
    fun testFunction1(): TestObject {
        return TestObject("Ciao")
    }

    data class TestObject(val desc: String)

}