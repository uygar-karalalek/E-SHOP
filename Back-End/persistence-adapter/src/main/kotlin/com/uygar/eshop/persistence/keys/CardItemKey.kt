package com.uygar.eshop.persistence.keys

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CardItemKey(

    @Column(name = "fk_card")
    val cardId: Long = 0,

    @Column(name = "product_id")
    val productId: Long = 0

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardItemKey

        if (cardId != other.cardId) return false
        if (productId != other.productId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cardId.hashCode()
        result = 31 * result + productId.hashCode()
        return result
    }

}