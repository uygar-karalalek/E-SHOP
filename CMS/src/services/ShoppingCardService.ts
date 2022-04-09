import axios from "axios";
import {Product} from "../interfaces/Product";
import {CardItem} from "../interfaces/CardItem";

export class ShoppingCardService {

    async getUserCardItems(userId: number) {
        return await axios.get(`/card/${userId}/products`).then(value => {
            const items: Array<CardItem> = value.data
            return items;
        })
    }

    async addShoppingCard() {
        return await axios.post("/card/add", JSON.stringify({cardItems: []}),
            {headers: {'content-type': "application/json"}})
    }

    async addProductToCard(cardId: number, product: Product) {
        let url = `/card/addProduct`;
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
        let url = `/card/${cardId}/addProduct/${productId}`;
        return await axios.post(url)
    }

    async remove(cardId: bigint, productId: bigint) {
        let url = `/card/${cardId}/removeProduct/${productId}`;
        return await axios.post(url)
    }

}