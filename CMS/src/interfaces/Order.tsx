import {OrderProduct} from "./OrderProduct";

export interface Order {

    id: number
    userId: number
    status: number
    dateAdded: Date,
    orderProducts: Array<OrderProduct>

}