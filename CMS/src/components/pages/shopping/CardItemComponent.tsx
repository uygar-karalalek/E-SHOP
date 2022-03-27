import * as React from "react";
import {CardItem} from "../../../interfaces/CardItem";
import axios from "axios";
import {ApplicationServices} from "../../../services/ApplicationServices";

export class CardItemComponent extends React.Component<{
    item: CardItem,
    addToPrice: (price: number) => void,
    appServices: ApplicationServices
}, { quantity: bigint }> {

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
                <td>
                    <button onClick={this.add}>Add</button>
                </td>
                <td>
                    <button onClick={this.remove}>Remove</button>
                </td>
            </tr>
        ); else return <span></span>;
    }

    add(event: React.MouseEvent<HTMLElement>) {
        const final = Number(this.state.quantity) + 1

        this.props.appServices.shoppingCardService.addExistingItemToCard(
            this.props.item.productId,
            this.props.item.cardId).then(_ => {
            this.setState({quantity: BigInt(final)});
            this.props.addToPrice(this.props.item.productPrice)
        })
    }

    remove(event: React.MouseEvent<HTMLElement>) {
        var factor = 1;
        var final = Number(this.state.quantity) - factor
        this.props.appServices.shoppingCardService.remove(this.props.item.cardId, this.props.item.productId).then(_ => {
            this.setState({quantity: BigInt(final)});
            this.props.addToPrice(-this.props.item.productPrice)
        }).catch(reason => console.log(reason))
    }

}