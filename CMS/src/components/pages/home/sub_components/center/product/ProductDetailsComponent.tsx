import * as React from 'react';
import {Product} from "../../../../../../interfaces/Product";
import axios from "axios";

type Props = {
    product: Product,
    setViewProductDetails: (det: Product) => void
};

export class ProductDetailsComponent extends React.Component<Props, {}> {

    constructor(props: Props) {
        super(props);
        this.setViewProductDetails = this.setViewProductDetails.bind(this);
        this.callApi = this.callApi.bind(this);
    }

    setViewProductDetails() {
        this.props.setViewProductDetails(null)
    }

    render() {
        return (
            <div style={{width: "60%"}}>
                <h3>Product Details</h3>
                <div style={{color: "#c6ce86"}}>Title:</div>
                <div>{this.props.product.title}</div>
                <div style={{color: "#c6ce86"}}>Description:</div>
                <div>{this.props.product.description}</div>
                <div style={{color: "#c6ce86"}}>Price:</div>
                <div>{this.props.product.price} CHF</div>
                <br/>
                <button onClick={this.callApi}>Buy</button>
                <button onClick={this.setViewProductDetails} style={{background: "red", color: "white"}}>Back</button>
            </div>
        );
    }

    callApi(event: React.MouseEvent<HTMLElement>) {
        let url = '/card/1/products/add';
        axios.post(url, {
            cardId: 1,
            productPrice: this.props.product.price,
            productTitle: this.props.product.title,
            productId: this.props.product.id,
            quantity: 1,
            dateAdded: null
        })
            .then(res => {
                const persons = res.data;
                this.setState({persons});
            }).catch(reason => console.log(reason))
    }

}