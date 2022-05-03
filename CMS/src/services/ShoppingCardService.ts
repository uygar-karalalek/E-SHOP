import axios from "axios";
import {Product} from "../interfaces/Product";
import {CardItem} from "../interfaces/CardItem";
import {CardItemAddOperationTypeResult} from "../interfaces/CardItemAddOperationTypeResult";

export class ShoppingCardService {

    async getUserCardItems(userId: number) {
        return await axios.get(`/card/${userId}/products`).then(value => {
            const items: Array<CardItem> = value.data
            return items;
        })
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
            console.log(response.data)
            let data: CardItemAddOperationTypeResult = response.data;
            return data
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