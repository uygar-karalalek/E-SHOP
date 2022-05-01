import {Filter} from "../interfaces/Filter";
import {Product} from "../interfaces/Product";
import {ApplicationServices} from "./ApplicationServices";

export class FilterService {

    appServices: ApplicationServices
    filter: Filter = new Filter()

    constructor(appServices: ApplicationServices) {
        this.appServices = appServices;
    }

    async getProductTitleFiltered() {
        return await this.appServices.productService.getAllProducts().then((items: Array<Product>) => {
            return items.filter(item => item.title.includes(this.filter.productTitle))
        })
    }

    setProductTitleFilter(title: string) {
        console.log("CHANGING")
        this.filter.productTitle = title
    }

}