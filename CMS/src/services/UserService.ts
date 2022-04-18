import axios from "axios";
import {ShoppingCard} from "../interfaces/ShoppingCard";
import {User} from "../interfaces/User";
import {CardItem} from "../interfaces/CardItem";
import {ShoppingCardService} from "./ShoppingCardService";
import {CookieService} from "./CookieService";
import {UtilService} from "./UtilService";

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
        return await this.getUserIdByStoredToken().then((userId: number) => {
                return this.shoppingCardService.getUserCardItems(userId).then((cardItems: Array<CardItem>) => {
                    return this.utilService.arraySum(cardItems)
                })
            }
        )
    }

    async createGuest(guestName: string) {
        return await axios.post("/users/add", JSON.stringify({
                id: -1,
                name: "",
                surname: "",
                address: "",
                email: guestName + "@guest.com",
                password: "",
                guest: true,
                shoppingCard: null
            }
        ), {headers: {'content-type': "application/json"}}).then((userJson) => {
            let user: User = JSON.parse(JSON.stringify(userJson.data))
            console.log(user.id)
             this.cookieService.setToken(guestName)
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

    async getUserIdByStoredToken() {
        return await this.getUserByStoredToken().then((value: User) => {
            return value.id
        });
    }

}