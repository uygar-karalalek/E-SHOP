import axios from "axios";
import {Product} from "../interfaces/Product";

export class ProductService {

    async getAllProducts() {
        return await axios.get('/products')
            .then(res => {
                let products : Array<Product> = res.data;
                return products;
            })
    }

}