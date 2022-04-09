package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "user")
@Entity
class User(

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1L,

    @Column(name = "name")
    val name: String,

    @Column(name = "surname")
    val surname: String,

    @Column(name = "address")
    val address: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "guest")
    val guest: Boolean,

    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "user",
        orphanRemoval = true
    )
    var orders: MutableList<Order> = arrayListOf(),

) {

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    @PrimaryKeyJoinColumn
    var shoppingCard: ShoppingCard? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (address != other.address) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (guest != other.guest) return false
        if (orders != other.orders) return false
        if (shoppingCard != other.shoppingCard) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + guest.hashCode()
        result = 31 * result + orders.hashCode()
        result = 31 * result + (shoppingCard?.hashCode() ?: 0)
        return result
    }


}