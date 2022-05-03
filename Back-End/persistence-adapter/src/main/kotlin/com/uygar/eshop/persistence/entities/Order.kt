package com.uygar.eshop.persistence.entities

import java.time.ZonedDateTime
import java.util.DoubleSummaryStatistics
import javax.persistence.*

@Table(name = "`order`")
@Entity
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "fk_user")
    val user: User,

    @Column(name = "totalPrice")
    val totalPrice: Double,

    @Column(name = "receiverAddress")
    val receiverAddress: String,

    @Column(name = "receiverFullName")
    val receiverFullName: String,

    @Column(name = "status")
    val status: Int,

    @Column(name = "dateAdded")
    val dateAdded: ZonedDateTime,

    @Column(name = "product_orders")
    @OneToMany
    @JoinColumn(name = "fk_order")
    val orderProducts: List<OrderProduct>

)