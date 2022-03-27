import {UserService} from "./UserService";
import {CookieService} from "./CookieService";
import {ShoppingCardService} from "./ShoppingCardService";
import {UtilService} from "./UtilService";

export class ApplicationServices {

    cookieService: CookieService = new CookieService();
    shoppingCardService: ShoppingCardService = new ShoppingCardService();
    utilService: UtilService = new UtilService();

    userService: UserService = new UserService(this.shoppingCardService, this.cookieService, this.utilService)

}