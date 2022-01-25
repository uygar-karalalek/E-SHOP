package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "`order`")
@Entity
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "status")
    val status: Boolean,

    @OneToMany(mappedBy = "order")
    val productOrders: List<ProductOrder>

)