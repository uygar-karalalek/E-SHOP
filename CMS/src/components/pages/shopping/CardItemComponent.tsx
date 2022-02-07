import * as React from "react";
import {CardItem} from "../../../interfaces/CardItem";
import {Card} from "react-bootstrap";

export class CardItemComponent extends React.Component<CardItem> {

    constructor(props: CardItem) {
        super(props);
    }

    render() {
        return (
            <Card style={{ width: '10rem' }}>
                <Card.Body>
                    <label>{this.props.quantity}</label>
                    <Card.Subtitle className="mb-2 text-muted">Item Subtitle</Card.Subtitle>
                    <Card.Text>Price: {this.props.productId}</Card.Text>
                    <Card.Text>Description: {this.props.dateAdded}</Card.Text>
                </Card.Body>
            </Card>
        );
    }

}