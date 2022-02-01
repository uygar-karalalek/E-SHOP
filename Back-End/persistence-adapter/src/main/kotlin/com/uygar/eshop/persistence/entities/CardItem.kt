package com.uygar.eshop.persistence.entities

import com.uygar.eshop.persistence.keys.CardItemKey
import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "card_item")
@Entity
class CardItem(

    @EmbeddedId
    val id: CardItemKey,

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "fk_product")
    val product: Product? = null,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "dateAdded")
    val dateAdded: ZonedDateTime

)