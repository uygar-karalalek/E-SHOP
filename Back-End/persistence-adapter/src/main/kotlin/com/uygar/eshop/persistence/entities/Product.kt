package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "product")
@Entity
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(name = "title")
    private val title: String = "",

    @Column(name = "price")
    private val price: Double = 0.0,

    @Column(name = "description")
    private val description: String = "",

    @OneToMany(mappedBy = "product")
    private val productsInCard: Set<CardProduct>,

    @OneToMany(mappedBy = "product")
    private val productOrders: Set<ProductOrder>

    )