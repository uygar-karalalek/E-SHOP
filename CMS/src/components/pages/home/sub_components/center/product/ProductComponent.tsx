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
            <Card style={{ width: '15rem', marginRight: 10, marginTop: 10, backgroundColor: "#545f6b", color: "white" }} >
                <Card.Body>
                    <div>
                        <Card.Img onClick={this.setProductForViewDetails} style={{borderColor: "red",
                            borderStyle: "solid",
                            marginBottom: '2rem',
                            width: "100%",
                            height: "10vw",
                            objectFit: "cover"}} src={"sample.png"} />
                        <label style={{ overflow: "hidden", textAlign: "left", marginBottom: "2rem", height: 70 }}>{this.props.product.title}</label>
                        <Card.Text style={{fontWeight: "bold", color: "#5db453", height: 10, marginBottom: 30 }}>{this.props.product.price} CHF</Card.Text>
                        <button onClick={this.callApi}>Buy</button>
                    </div>
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