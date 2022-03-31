export class OrderProductWrite {

    orderId: bigint
    product: {
        productId: bigint,
        price: number,
        title: string,
    }
    quantity: bigint
    dateAdded: Date

    constructor(orderId: bigint, product: { productId: bigint; price: number; title: string }, quantity: bigint, dateAdded: Date) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }
}