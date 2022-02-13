import * as React from "react";
import {CardItem} from "../../../interfaces/CardItem";
import axios from "axios";

export class CardItemComponent extends React.Component<{ item: CardItem, addToPrice: (price: number) => void }, { quantity: bigint }> {

    constructor(props: any) {
        super(props);
        this.add = this.add.bind(this);
        this.remove = this.remove.bind(this);
        this.state = {
            quantity: this.props.item.quantity,
        }
    }

    render() {
        // @ts-ignore
        const quantity = Number(this.state.quantity)
        if (quantity > 0) return (
            <tr>
                <td>{this.props.item.productTitle}</td>
                <td>{this.props.item.productPrice} .-</td>
                <td>{quantity.toString()}</td>
                <td><button onClick={this.add}>Add</button></td>
                <td><button onClick={this.remove}>Remove</button></td>
            </tr>
        ); else return <span></span>;
    }

    add(event: React.MouseEvent<HTMLElement>) {
        let url = '/card/1/products/add';
        var factor = 1;
        var final = Number(this.state.quantity) + factor
        axios.post(url, {
            cardId: 1,
            productPrice: this.props.item.productPrice,
            productTitle: this.props.item.productTitle,
            productId: this.props.item.productId,
            quantity: 1,
            dateAdded: null
        })
            .then(res => {
                this.setState({quantity: BigInt(final)});
                this.props.addToPrice(this.props.item.productPrice)
            }).catch(reason => console.log(reason))
    }

    remove(event: React.MouseEvent<HTMLElement>) {
        let url = '/card/1/products/remove';
        var factor = 1;
        var final = Number(this.state.quantity) - factor
        axios.post(url, {
            cardId: 1,
            productPrice: this.props.item.productPrice,
            productTitle: this.props.item.productTitle,
            productId: this.props.item.productId,
            quantity: 1,
            dateAdded: null
        })
            .then(res => {
                this.setState({quantity: BigInt(final)});
                this.props.addToPrice(-this.props.item.productPrice)
            }).catch(reason => console.log(reason))
    }

}