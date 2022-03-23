import axios from "axios";
import {ShoppingCard} from "../interfaces/ShoppingCard";
import {User} from "../interfaces/User";

export class EShopService {

    getToken(): string {
        const tokenString = localStorage.getItem("e_shop_token")
        if (tokenString != null && tokenString !== "") {
            let stringTokenJSON = JSON.parse(tokenString);
            const tokenObject = JSON.parse(stringTokenJSON)
            return tokenObject.token;
        }
        return ""
    }

    setToken(userToken: any) {
        localStorage.setItem("e_shop_token", JSON.stringify(userToken))
    }

    computeTotalPrice(): number {
        let userToken = this.getToken()
        let user = this.getUserByToken(userToken)
        return user.shoppingCard.cardItems.map(item => item.productPrice * Number(item.quantity))
            .reduce((sum, curr) => sum + curr, 0)
    }

    createGuest(guestName: string) {
        let shopCard: ShoppingCard;
        axios.post("/card/add", JSON.stringify({cardItems: []}),
            {headers: {'content-type': "application/json"}})
            .then(value => { shopCard = value.data })

        axios.post("/users/add", JSON.stringify({
                email: guestName + "@guest.com",
                shoppingCard: {
                    id: shopCard.id,
                    cardItems: shopCard.cardItems
                }
            }
        ), {headers: {'content-type': "application/json"}})

        this.setToken(guestName)
    }

    getUserByToken(token: string): User {
        let user: User;
        axios.get("/users").then(value => {
            user = value.data
        })
        return user
    }

}