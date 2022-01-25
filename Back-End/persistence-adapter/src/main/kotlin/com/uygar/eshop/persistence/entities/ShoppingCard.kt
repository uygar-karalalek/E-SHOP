package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "shopping_card")
@Entity
class ShoppingCard(

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1L,

    @OneToOne(mappedBy = "shoppingCard")
    var user: User,

    @OneToMany(mappedBy = "shoppingCard")
    var cardItems: List<CardItem>

)