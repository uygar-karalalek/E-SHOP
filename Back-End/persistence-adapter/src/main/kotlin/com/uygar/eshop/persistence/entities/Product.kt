package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "product")
@Entity
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    val title: String = "",

    @Column(name = "price")
    val price: Double = 0.0,

    @Column(name = "description")
    val description: String = "",

    @OneToMany(mappedBy = "product")
    val productsInCard: Set<CardItem>,

    @OneToMany(mappedBy = "product")
    val productOrders: Set<ProductOrder>

)