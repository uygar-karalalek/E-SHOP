package com.uygar.eshop.persistence.entities

import java.time.ZonedDateTime
import javax.persistence.*

@Table(name = "`order`")
@Entity
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "status")
    val status: Int,

    @Column(name = "product_orders")
    @OneToMany
    @JoinColumn(name = "fk_order")
    val orderProducts: List<OrderProduct>,

    @Column(name = "dateAdded")
    val dateAdded: ZonedDateTime

)