import axios from "axios";
import {Order} from "../interfaces/Order";
import {PayPalOrder} from "../interfaces/PayPalOrder";

export class PaymentService {

    async getPaypalOrder(orderId: number, accessToken: string) {
        await console.log("öALSKDASD")

        return await axios.get(`https://api-m.sandbox.paypal.com/v2/checkout/orders/${orderId}`,
            {
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${accessToken}`
                }
            }).then(apiResp => {
            console.log(">")
            console.log(apiResp)

            let payPalOrder = apiResp.data.purchase_units[0];
            return new PayPalOrder(
                payPalOrder.amount.value,
                payPalOrder.amount.currency_code,
                payPalOrder.shipping.name.full_name,
                payPalOrder.shipping.address.address_line_1,
                payPalOrder.shipping.address.admin_area_2,
                payPalOrder.shipping.address.country_code,
                payPalOrder.shipping.address.postalCode,
                payPalOrder.shipping.address.admin_area_2
            )
        }).catch(reason => {console.log("ERROR1"); console.log(reason)})
            .finally(() => console.log("FINISHED"))
    }

    async addOrder(userId: number, order: {
        id: number, userId: number, totalPrice: number,
        receiverAddress: string, receiverFullName: string
        status: number, dateAdded?: Date
    }) {
        return await axios.post(`/user/${userId}/orders/add`, JSON.stringify(order),
            {headers: {'content-type': "application/json"}})
    }

    async getUserOrders(userId: number) {
        return await axios.get(`/user/${userId}/orders`).then(apiResponse => {
            let orders: Array<Order> = apiResponse.data
            return orders
        })
    }

}