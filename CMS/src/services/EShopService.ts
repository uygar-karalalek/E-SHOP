import axios from "axios";
import {ShoppingCard} from "../interfaces/ShoppingCard";
import {User} from "../interfaces/User";
import {CardItem} from "../interfaces/CardItem";
import {fsReadFile} from "ts-loader/dist/utils";

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

    computeTotalUserPrice() {
        let userToken = this.getToken()
        let user = this.getUserByToken(userToken)
        return this.computeTotalPrice(user.shoppingCard.cardItems)
    }

    createGuest(guestName: string) {
        this.addShoppingCard().then(value => {
            let shopCard: ShoppingCard = JSON.parse(JSON.stringify(value.data))
            axios.post("/users/add", JSON.stringify({
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
        this.setToken(guestName)
    }

    async addShoppingCard() {
        return await axios.post("/card/add", JSON.stringify({cardItems: []}),
            {headers: {'content-type': "application/json"}})
    }

    getUserByToken(token: string): User {
        let user: User;
        this.getUser(token).then(value => {
            console.log(value+"<<")
            user = JSON.parse(JSON.stringify((value.data)))
            return user
        }).catch(reason => console.log(reason))
        return user
    }

    async getUser(token: string) {
        return await axios.get("/users/get", {
                headers: {'content-type': "application/json"},
                params: {token: token}
            }
        )
    }

    getUserByStoredToken(): User {
        return this.getUserByToken(this.getToken())
    }

}