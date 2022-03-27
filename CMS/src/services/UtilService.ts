import {CardItem} from "../interfaces/CardItem";

export class UtilService {
    arraySum(numbers: Array<CardItem>): number {
        return numbers.map(item => item.productPrice * Number(item.quantity))
            .reduce((sum, curr) => sum + curr, 0)
    }
}