import {UserService} from "./UserService";
import {CookieService} from "./CookieService";
import {ShoppingCardService} from "./ShoppingCardService";
import {UtilService} from "./UtilService";
import {OrderService} from "./OrderService";

export class ApplicationServices {

    cookieService: CookieService = new CookieService();
    shoppingCardService: ShoppingCardService = new ShoppingCardService();
    orderService: OrderService = new OrderService();
    utilService: UtilService = new UtilService();

    userService: UserService = new UserService(this.shoppingCardService, this.cookieService, this.utilService)

}