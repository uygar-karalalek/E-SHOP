package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "user")
@Entity
class User(

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1L,

    @Column(name = "name")
    val name: String,

    @Column(name = "surname")
    val surname: String,

    @Column(name = "address")
    val address: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @OneToOne
    @JoinColumn(name = "user_shopping")
    val shoppingCard: ShoppingCard,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "user_id")
    var orders: MutableList<Order> = arrayListOf()

)