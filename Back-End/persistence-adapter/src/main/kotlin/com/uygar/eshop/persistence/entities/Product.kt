package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "product")
@Entity
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "title")
    val title: String = "",

    @Column(name = "price")
    val price: Double = 0.0,

    @Column(name = "description")
    val description: String = "",

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (title != other.title) return false
        if (price != other.price) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}