import * as React from "react";
import {Component} from "react";
import axios from "axios";
import {CardItem} from "../../../interfaces/CardItem";
import {CardItemComponent} from "./CardItemComponent";
import {NavigateFunction, useNavigate} from "react-router-dom";

interface Props {
    navigator: NavigateFunction,
    setPrice: (price: number) => void
}

export class Shopping extends Component<Props, {}> {

    private totalPrice: number

    constructor(props: Props) {
        super(props);
        this.goToPaymentPage = this.goToPaymentPage.bind(this)
    }

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

    goToPaymentPage() {
        this.props.setPrice(this.totalPrice)
        console.log(Math.round(this.totalPrice * 100) / 100)
        this.props.navigator("/shopping/payment")
    }

    render() {
        this.totalPrice = this.computeTotalPrice()
        this.totalPrice = Math.round(this.totalPrice * 100) / 100

        return <div>
            <table style={{margin: 10}} className="table table-hover">
                <thead>
                <tr>
                    <th style={{width: "16.66%"}} scope="col">Title</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                </tr>
                </thead>
                <tbody>
                {
                    this.state.cardItems.map((item) => {
                        return <CardItemComponent productPrice={item.productPrice} productTitle={item.productTitle}
                                                  cardId={item.cardId} quantity={item.quantity}
                                                  dateAdded={item.dateAdded}
                                                  productId={item.productId}/>
                    })}
                </tbody>
            </table>
            <div style={{
                borderColor: "#3397c7",
                borderStyle: "solid",
                padding: 10,
                color: "green",
                margin: 10,
                marginTop: 100
            }}>
                <span>Totale: {" "}</span> <span style={{color: "red"}}>{
                    this.totalPrice
            } .-</span>
                <button onClick={this.goToPaymentPage} style={{marginLeft: 50, width: 100}} type="button"
                        className="btn btn-primary">buy
                </button>
            </div>
        </div>;
    }

    private computeTotalPrice(): number {
        return this.state.cardItems.length > 0 ?
            this.state.cardItems.map((item) => {
                return (item.productPrice * Number(item.quantity))
            }).reduce((previousValue, currentValue) => previousValue + currentValue) : 0;
    }
}

export function ShoppingWithRouter(props: { setPrice: (amount: number) => void }) {
    let navigator = useNavigate();
    return <Shopping setPrice={props.setPrice} navigator={navigator}/>
}