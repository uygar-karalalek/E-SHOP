package com.uygar.eshop.persistence.entities

import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "card_product")
@Entity
class CardProduct(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = -1L,

    @Column(name = "dateAdded")
    private val dateAdded: ZonedDateTime,

    @ManyToOne
    @JoinColumn(name = "shopping_id")
    private val shoppingCard: ShoppingCard,

    @ManyToOne
    @JoinColumn(name = "product_id")
    private val product: Product

)