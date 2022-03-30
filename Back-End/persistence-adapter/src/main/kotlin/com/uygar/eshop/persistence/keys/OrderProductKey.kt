package com.uygar.eshop.persistence.keys

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class OrderProductKey(

    @Column(name = "order_id")
    val orderId: Long = 0,

    @Column(name = "product_id")
    val productId: Long = 0

) : Serializable {

    fun getResultId(): Long {
        return "$orderId$productId".toLong()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardItemKey

        if (orderId != other.cardId) return false
        if (productId != other.productId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = orderId.hashCode()
        result = 31 * result + productId.hashCode()
        return result
    }

}