import * as React from "react";
import {CardItem} from "../../../interfaces/CardItem";

export class CardItemComponent extends React.Component<CardItem> {

    constructor(props: CardItem) {
        super(props);
    }

    render() {
        return (
            <tr>
                <td>{this.props.productTitle}</td>
                <td>{this.props.productPrice} .-</td>
                <td>{this.props.quantity}</td>
            </tr>
        );
    }

}