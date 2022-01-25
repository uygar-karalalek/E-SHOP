package com.uygar.eshop.core

data class Product(

    val id: Long,

    val title: String = "",

    val price: Double = 0.0,

    val description: String = "",

    val cardItems: List<CardItem>,

    val productOrders: List<ProductOrder>

)