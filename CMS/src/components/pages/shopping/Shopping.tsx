import * as React from "react";
import {Component} from "react";
import axios from "axios";
import {CardItem} from "../../../interfaces/CardItem";
import {CardItemComponent} from "./CardItemComponent";

export class Shopping extends Component<{}, {}> {

    state = {
        cardItems: Array<CardItem>()
    }

    componentDidMount() {
        axios.get('/card/1/products')
            .then(res => {
                const items = res.data;
                this.setState({cardItems: items});
            })
    }

    render() {
        return <div>
            <div className="d-flex flex-wrap">
                {this.state.cardItems.map((item) => {
                    console.log(item)
                    return <CardItemComponent cardId={item.cardId} quantity={item.quantity} dateAdded={item.dateAdded} productId={item.productId} />
                })}
            </div>
        </div>;
    }
}