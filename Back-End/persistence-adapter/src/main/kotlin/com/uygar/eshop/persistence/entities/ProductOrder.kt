package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Table(name = "product_order")
@Entity
class ProductOrder(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @ManyToOne
    @JoinColumn(name = "product_id")
    private val product: Product,

    @ManyToOne
    @JoinColumn(name = "order_id")
    private val order: Order

)