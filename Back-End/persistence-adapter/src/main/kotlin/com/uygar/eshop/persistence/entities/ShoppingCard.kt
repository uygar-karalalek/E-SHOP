package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "shopping_card")
@Entity
class ShoppingCard(

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1L,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "fk_card")
    var cardItems: MutableList<CardItem> = arrayListOf()

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShoppingCard

        if (id != other.id) return false
        if (cardItems != other.cardItems) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + cardItems.hashCode()
        return result
    }
}