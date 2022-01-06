package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "shopping_card")
@Entity
class ShoppingCard (

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = -1L,

    @OneToOne(mappedBy = "shoppingCard")
    private val user: User? = null

)