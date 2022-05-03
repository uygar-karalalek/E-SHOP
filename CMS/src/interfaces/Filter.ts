export class Filter {

    productTitle: string
    priceMinimum?: number
    priceMaximum?: number
    category?: string

    constructor(nameOfTheProduct: string = "",
                priceMinimum: number = null,
                priceMaximum: number = null,
                category: string = null) {
        this.productTitle = nameOfTheProduct;
        this.priceMinimum = priceMinimum;
        this.priceMaximum = priceMaximum;
        this.category = category;
    }


}