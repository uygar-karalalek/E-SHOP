import {ShoppingCard} from "./ShoppingCard";

export interface User {
    id: number,
    name: String,
    surname: String,
    address: String,
    email: String,
    password: String,
    shoppingCard: ShoppingCard
}