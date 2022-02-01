import * as React from "react";
import {Card} from "react-bootstrap";
import {Product} from "../../interfaces/Product";
import axios from "axios";

export class ProductComponent extends React.Component<Product, {}> {

    constructor(props: Product) {
        super(props);
    }

    render() {
        return (
            <Card style={{ width: '10rem' }}>
                <Card.Body>
                    <Card.Title>{this.props.title}</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">Item Subtitle</Card.Subtitle>
                    <Card.Text>Price: {this.props.price}</Card.Text>
                    <Card.Text>Description: {this.props.description}</Card.Text>
                    <Card.Link onClick={ this.callApi }>Add to card</Card.Link>
                </Card.Body>
            </Card>
        );
    }

    callApi(event: React.MouseEvent<HTMLElement>) {
        let url = '/card/' + 1 + '/products/add/' + 1;
        axios.post(url)
            .then(res => {
                const persons = res.data;
                console.log(persons)
                this.setState({persons});
            })
    }

}