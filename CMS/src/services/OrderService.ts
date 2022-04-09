import axios from "axios";

export class OrderService {

    async addOrder(userId: number, order: { id: number, userId: number, status: number, dateAdded?: Date }) {
        return axios.post(`/user/${userId}/orders/add`, JSON.stringify(order),
            {headers: {'content-type': "application/json"}})
    }

}