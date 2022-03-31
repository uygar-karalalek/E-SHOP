import axios from "axios";
import {OrderProductWrite} from "../interfaces/OrderProductWrite";
import {Order} from "../interfaces/Order";


export class OrderService {

    async addOrder(userId: number, orderWithItems: Order) {
        return await axios.post(`/user/${userId}/orders/add`, JSON.stringify(JSON.stringify(orderWithItems)),
            {headers: {'content-type': "application/json"}})
    }

}