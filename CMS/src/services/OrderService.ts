import axios from "axios";
import {Order} from "../interfaces/Order";

export class OrderService {

    async addOrder(userId: number, order: { id: number, userId: number, status: number, dateAdded?: Date }) {
        return axios.post(`/user/${userId}/orders/add`, JSON.stringify(order),
            {headers: {'content-type': "application/json"}})
    }

    async getUserOrders(userId: number) {
        return axios.get(`/user/${userId}/orders`).then(apiResponse => {
            let orders: Array<Order> = apiResponse.data
            return orders
        })
    }

}