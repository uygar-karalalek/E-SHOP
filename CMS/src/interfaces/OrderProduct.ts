export interface OrderProduct {
    orderId: number,

    productPrice: number,

    productTitle: string,

    productId: bigint,

    quantity: bigint,

    dateAdded?: Date
}