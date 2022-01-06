package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name="user")
@Entity
class User (

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1L,

    @Column(name = "name")
    private val name: String = "",

    @Column(name = "surname")
    private val surname: String = "",

    @Column(name = "address")
    private val address: String = "",

    @Column(name = "email")
    private val email: String = "",

    @Column(name = "password")
    private val password: String = "",

    @OneToOne
    @JoinColumn(name="user_shopping")
    private val shoppingCard: ShoppingCard? = null

)