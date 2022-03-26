import axios from "axios";
import {ShoppingCard} from "../interfaces/ShoppingCard";
import {User} from "../interfaces/User";
import {CardItem} from "../interfaces/CardItem";
import {fsReadFile} from "ts-loader/dist/utils";
import {useDebugValue} from "react";

export class EShopService {

    getToken(): string {
        return localStorage.getItem("e_shop_token")
    }

    setToken(userToken: any) {
        localStorage.setItem("e_shop_token", JSON.stringify(userToken)
            .replace(/"/gi, ''))
    }

    computeTotalPrice(cardItems: Array<CardItem>): number {
        return cardItems.map(item => item.productPrice * Number(item.quantity))
            .reduce((sum, curr) => sum + curr, 0)
    }

    async computeTotalUserPrice() {
        return await this.getUserByStoredToken().then(value => {
                let user: User = JSON.parse(JSON.stringify(value.data))
                return this.computeTotalPrice(user.shoppingCard.cardItems)
            }
        )
    }

    async createGuest(guestName: string) {
        return await this.addShoppingCard().then(value => {
            this.setToken(guestName)

            let shopCard: ShoppingCard = JSON.parse(JSON.stringify(value.data))
            return axios.post("/users/add", JSON.stringify({
                    id: -1,
                    name: "",
                    surname: "",
                    address: "",
                    email: guestName + "@guest.com",
                    password: "",
                    guest: true,
                    shoppingCard: {
                        id: shopCard.id,
                        cardItems: shopCard.cardItems
                    }
                }
            ), {headers: {'content-type': "application/json"}})
        })
    }

    async addShoppingCard() {
        return await axios.post("/card/add", JSON.stringify({cardItems: []}),
            {headers: {'content-type': "application/json"}})
    }

    async getUser(token: string) {
        return await axios.get("/users/get/" + token, {
                headers: {'Accept': "application/json"}
            }
        )
    }

    async getUserByStoredToken() {
        return await this.getUser(this.getToken())
    }

}