import axios from "axios";
import {Order} from "../interfaces/Order";
import {OrderProduct} from "../interfaces/OrderProduct";

export class OrderService {

    async addOrder(userId: number, order: { id: number, userId: number, status: number, dateAdded?: Date }) {
        return await axios.post(`/user/${userId}/orders/add`, JSON.stringify(order),
            {headers: {'content-type': "application/json"}})
    }

    async getUserOrders(userId: number) {
        return await axios.get(`/user/${userId}/orders`).then(apiResponse => {
            let orders: Array<Order> = apiResponse.data
            return orders
        })
    }

    async getOrderProducts(orderId: number) {
        return axios.get(`/orders/${orderId}/products`).then(value => {
            let prods: Array<OrderProduct> = value.data;
            return prods
        })
    }

}