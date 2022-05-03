import * as React from 'react';
import {Product} from "../../../../../../interfaces/Product";
import axios from "axios";
import {ApplicationServices} from "../../../../../../services/ApplicationServices";
import {User} from "../../../../../../interfaces/User";
import {CardItemAddOperationTypeResult} from "../../../../../../interfaces/CardItemAddOperationTypeResult";

type Props = {
    product: Product,
    setViewProductDetails: (det: Product) => void
    appServices: ApplicationServices,
    cartUpdate: any
    numOfItems: number
};

export class ProductDetailsComponent extends React.Component<Props, {}> {

    constructor(props: Props) {
        super(props);
        this.setViewProductDetails = this.setViewProductDetails.bind(this);
        this.addItem = this.addItem.bind(this);
    }

    setViewProductDetails() {
        this.props.setViewProductDetails(null)
    }

    render() {
        return (
            <div style={{padding: 30, width: "60%", color: "white"}}>
                <h3>Product Details</h3>
                <div style={{color: "#c6ce86"}}>Title:</div>
                <div>{this.props.product.title}</div>
                <div style={{color: "#c6ce86"}}>Description:</div>
                <div>{this.props.product.description}</div>
                <div style={{color: "#c6ce86"}}>Price:</div>
                <div>{this.props.product.price} CHF</div>
                <br/>
                <button onClick={this.addItem}>Buy</button>
                <button onClick={this.setViewProductDetails} style={{background: "red", color: "white"}}>Back</button>
            </div>
        );
    }

    addItem(event: React.MouseEvent<HTMLElement>) {
        this.props.appServices.userService.getUserByStoredToken().then((user: User) => {
            return this.props.appServices.shoppingCardService
                // USER ID VALUES IS THE SAME AS THE CARD ID VALUE!
                .addProductToCard(user.id, this.props.product).then((operationResult: CardItemAddOperationTypeResult) => {
                    if (!operationResult.operationIsQuantityIncrement)
                        this.props.cartUpdate(this.props.numOfItems+1)
                })
        })
    }

}