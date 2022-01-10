package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "`order`")
@Entity
class Order(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(name = "status")
    private val status: Boolean,

    @OneToMany(mappedBy = "order")
    private val productOrders: Set<ProductOrder>

)