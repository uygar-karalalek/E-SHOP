package com.uygar.eshop.persistence.entities

import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "card_item")
@Entity
class CardItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1L,

    @Column(name = "dateAdded")
    val dateAdded: ZonedDateTime,

    @ManyToOne
    @JoinColumn(name = "shopping_id")
    val shoppingCard: ShoppingCard,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product

)