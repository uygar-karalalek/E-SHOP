import * as React from "react";
import {Card} from "react-bootstrap";
import {Product} from "../../../../../../interfaces/Product";
import axios from "axios";
import {fsReadFile} from "ts-loader/dist/utils";

export class ProductComponent extends React.Component<Product, {}> {

    constructor(props: Product) {
        super(props);
        this.callApi = this.callApi.bind(this)
    }

    render() {
        return (
            <Card style={{ width: '15rem' }} >
                <Card.Body>
                    <Card.Img style={{marginBottom: '2rem'}} src={"sample.png"} />
                    <label style={{ textAlign: "left", color: "blue", marginBottom: "2rem" }}>{this.props.title}</label>
                    <Card.Text style={{fontWeight: "bold", color: "red"}}>{this.props.price} $</Card.Text>
                    <button onClick={this.callApi}>Buy</button>
                </Card.Body>
            </Card>
        );
    }

    callApi(event: React.MouseEvent<HTMLElement>) {
        let url = '/card/1/products/add';
        axios.post(url, {
            cardId: 1,
            productPrice: this.props.price,
            productTitle: this.props.title,
            productId: this.props.id,
            quantity: 1,
            dateAdded: null
        })
            .then(res => {
                const persons = res.data;
                this.setState({persons});
            }).catch(reason => console.log(reason))
    }

}