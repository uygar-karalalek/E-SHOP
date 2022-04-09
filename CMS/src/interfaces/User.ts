import {Order} from "./Order";

export interface User {
    id: number,
    name: String,
    surname: String,
    address: String,
    email: String,
    password: String,
    guest: boolean,
    orders: Array<Order>
}