import axios from "axios";
import {ShoppingCard} from "../interfaces/ShoppingCard";
import {User} from "../interfaces/User";
import {CardItem} from "../interfaces/CardItem";
import {fsReadFile} from "ts-loader/dist/utils";
import {useDebugValue} from "react";
import {ShoppingCardService} from "./ShoppingCardService";
import {CookieService} from "./CookieService";
import {UtilService} from "./UtilService";
import * as url from "url";

export class UserService {

    private shoppingCardService: ShoppingCardService
    private cookieService: CookieService
    private utilService: UtilService

    constructor(shoppingCardService: ShoppingCardService,
                cookieService: CookieService,
                utilService: UtilService) {
        this.shoppingCardService = shoppingCardService;
        this.cookieService = cookieService;
        this.utilService = utilService;
    }

    async computeTotalUserPrice() {
        return await this.getUserByStoredToken().then(user => {
                return this.utilService.arraySum(user.shoppingCard.cardItems)
            }
        )
    }

    async createGuest(guestName: string) {
        return await this.shoppingCardService.addShoppingCard().then(value => {
            this.cookieService.setToken(guestName)

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

    async getUser(token: string) {
        return await axios.get("/users/get/" + token, {
                headers: {'Accept': "application/json"}
            }
        )
    }

    async getUserByStoredToken() {
        return await this.getUser(this.cookieService.getToken()).then(value => {
            return JSON.parse(JSON.stringify(value.data))
        })
    }

}