package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "shopping_card")
@Entity
class ShoppingCard(

    userId: Long = -1L,

    @JoinColumn(name = "fk_card")
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    var cardItems: MutableList<CardItem> = arrayListOf(),

) {

    @Id
    @Column(name = "user_id")
    var id: Long = 0

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    var user: User = User(
        id = userId,
        name = "",
        surname = "",
        address = "",
        email = "",
        password = "",
        guest = true
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShoppingCard

        if (cardItems != other.cardItems) return false
        if (id != other.id) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cardItems.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + user.hashCode()
        return result
    }


}