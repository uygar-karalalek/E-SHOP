package com.uygar.eshop.persistence.entities

import javax.persistence.*

@Entity
@Table(name = "order_product")
class OrderProduct(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "fk_product")
    val product: Product,

    @Column(name = "quantity")
    val product_quantity: Int

)