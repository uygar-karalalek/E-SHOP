package com.uygar.eshop.persistence.entities

import com.uygar.eshop.persistence.keys.CardItemKey
import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "card_item")
@Entity
class CardItem(

    @EmbeddedId
    val id: CardItemKey = CardItemKey(),

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "fk_product")
    val product: Product? = Product(-1L),

    @Column(name = "quantity")
    var quantity: Int,

    @Column(name = "dateAdded")
    val dateAdded: ZonedDateTime

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardItem

        if (id != other.id) return false
        if (product != other.product) return false
        if (quantity != other.quantity) return false
        if (dateAdded != other.dateAdded) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (product?.hashCode() ?: 0)
        result = 31 * result + quantity
        result = 31 * result + dateAdded.hashCode()
        return result
    }
}