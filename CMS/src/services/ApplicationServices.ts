import {UserService} from "./UserService";
import {CookieService} from "./CookieService";
import {ShoppingCardService} from "./ShoppingCardService";
import {UtilService} from "./UtilService";
import {PaymentService} from "./PaymentService";
import {ProductService} from "./ProductService";
import {FilterService} from "./FilterService";

export class ApplicationServices {

    cookieService: CookieService = new CookieService();
    shoppingCardService: ShoppingCardService = new ShoppingCardService();
    orderPaymentService: PaymentService = new PaymentService();
    utilService: UtilService = new UtilService();
    productService: ProductService = new ProductService()
    filterService: FilterService = new FilterService(this)

    userService: UserService = new UserService(this.shoppingCardService, this.cookieService, this.utilService)

}