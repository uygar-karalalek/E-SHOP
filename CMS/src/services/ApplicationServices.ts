import {UserService} from "./UserService";
import {CookieService} from "./CookieService";
import {ShoppingCardService} from "./ShoppingCardService";
import {UtilService} from "./UtilService";
import {PaymentService} from "./PaymentService";

export class ApplicationServices {

    cookieService: CookieService = new CookieService();
    shoppingCardService: ShoppingCardService = new ShoppingCardService();
    paymentService: PaymentService = new PaymentService();
    utilService: UtilService = new UtilService();

    userService: UserService = new UserService(this.shoppingCardService, this.cookieService, this.utilService)

}