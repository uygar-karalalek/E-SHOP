import axios from "axios";
import {Product} from "../interfaces/Product";

export class ProductService {

    async getProductById(productId: number) {
        return await axios.get(`/products/${productId}`).then(value => {
            let prod: Product = value.data
            return prod
        })
    }

}