package com.uygar.eshop.persistence.entities

import com.uygar.eshop.persistence.keys.OrderProductKey
import javax.persistence.*

@Entity
@Table(name = "order_product")
class OrderProduct(

    @EmbeddedId
    val id: OrderProductKey = OrderProductKey(),

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "fk_product")
    val product: Product,

    @Column(name = "quantity")
    val product_quantity: Int

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderProduct

        if (id != other.id) return false
        if (product != other.product) return false
        if (product_quantity != other.product_quantity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + product.hashCode()
        result = 31 * result + product_quantity
        return result
    }

}