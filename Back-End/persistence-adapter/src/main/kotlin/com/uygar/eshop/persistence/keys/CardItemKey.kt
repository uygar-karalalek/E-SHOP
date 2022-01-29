package com.uygar.eshop.persistence.keys

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class CardItemKey : Serializable {

    @Column(name = "card_id")
    val cardId: Long = 0

    @Column(name = "product_id")
    val productId: Long = 0

}