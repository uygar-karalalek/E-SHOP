import {OrderProductWrite} from "./OrderProductWrite";

export class Order {

    id: number
    status: number
    orderProducts: Array<OrderProductWrite>

    constructor(id: number, status: number, orderProducts: Array<OrderProductWrite>) {
        this.id = id;
        this.status = status;
        this.orderProducts = orderProducts;
    }

}