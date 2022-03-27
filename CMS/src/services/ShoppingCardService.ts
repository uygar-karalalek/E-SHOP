import axios from "axios";
import {Product} from "../interfaces/Product";

export class ShoppingCardService {

    async addShoppingCard() {
        return await axios.post("/card/add", JSON.stringify({cardItems: []}),
            {headers: {'content-type': "application/json"}})
    }

    async addProductToCard(cardId: number, product: Product) {
        let url = `/card/addProduct`;
        console.log(cardId+"<<< card id")
        return await axios.post(url, {
            cardId: cardId,
            productPrice: product.price,
            productTitle: product.title,
            productId: product.id,
            quantity: 1,
            dateAdded: null
        }).then(response => {
            return response.data
        })
    }

    async addExistingItemToCard(productId: bigint, cardId: bigint) {
        let url = `/${cardId}/addProduct/${productId}`;
        return await axios.post(url)
    }

    async remove(cardId: bigint, productId: bigint) {
        let url = `/card/${cardId}/products/removeProduct/${productId}`;
        return await axios.post(url)
    }

}