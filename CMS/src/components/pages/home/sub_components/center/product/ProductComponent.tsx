import * as React from "react";
import {Card} from "react-bootstrap";
import {Product} from "../../../../../../interfaces/Product";
import axios from "axios";
import {fsReadFile} from "ts-loader/dist/utils";

export class ProductComponent extends React.Component<{ product: Product, setViewProductDetails: (det: Product) => void }, {}> {

    constructor(props: any) {
        super(props);
        this.callApi = this.callApi.bind(this)
        this.setProductForViewDetails = this.setProductForViewDetails.bind(this);
    }

    setProductForViewDetails() {
        this.props.setViewProductDetails(this.props.product)
    }

    render() {
        return (
            <Card style={{ width: '15rem' }} >
                <Card.Body>
                    <Card.Img onClick={this.setProductForViewDetails} style={{marginBottom: '2rem'}} src={"sample.png"} />
                    <label style={{ textAlign: "left", color: "blue", marginBottom: "2rem" }}>{this.props.product.title}</label>
                    <Card.Text style={{fontWeight: "bold", color: "red"}}>{this.props.product.price} $</Card.Text>
                    <button onClick={this.callApi}>Buy</button>
                </Card.Body>
            </Card>
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