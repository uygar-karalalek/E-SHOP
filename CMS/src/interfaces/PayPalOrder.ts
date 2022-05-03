export class PayPalOrder {

    amount: number
    currency: string
    receiverFullName: string
    shippingAddress: string
    shippingCity: string
    shippingCountry: string
    shippingPostalCode: string
    shippingArea: string

    public constructor(
        amount: number,
        currency: string,
        receiverFullName: string,
        shippingAddress: string,
        shippingCity: string,
        shippingCountry: string,
        shippingPostalCode: string,
        shippingArea: string) {
        this.amount = amount
        this.currency = currency
        this.receiverFullName = receiverFullName
        this.shippingAddress = shippingAddress
        this.shippingCity = shippingCity
        this.shippingCountry = shippingCountry
        this.shippingPostalCode = shippingPostalCode
        this.shippingArea = shippingArea

    }
}