package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "shopping_card")
@Entity
class ShoppingCard(

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1L,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "card_id")
    var cardItems: MutableList<CardItem> = arrayListOf()

)