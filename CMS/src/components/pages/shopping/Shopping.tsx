import * as React from "react";
import {Component} from "react";
import axios from "axios";
import {CardItem} from "../../../interfaces/CardItem";
import {CardItemComponent} from "./CardItemComponent";
import {NavigateFunction, useNavigate} from "react-router-dom";
import {EShopService} from "../../../services/EShopService";

interface Props {
    navigator: NavigateFunction,
    eShopService: EShopService
}

export class Shopping extends Component<Props, { totalPrice: number, cardItems: Array<CardItem> }> {

    constructor(props: Props) {
        super(props);
        this.goToPaymentPage = this.goToPaymentPage.bind(this)
        this.addTotalPrice = this.addTotalPrice.bind(this);
        this.state = {
            totalPrice: 0,
            cardItems: Array<CardItem>()
        }
    }

    componentDidMount() {
        axios.get('/card/1/products')
            .then(res => {
                const items = res.data;
                this.setState({cardItems: items});
                this.setState({totalPrice: this.props.eShopService.computeTotalPrice()});
            })
    }

    goToPaymentPage() {
        console.log(Math.round(this.state.totalPrice * 100) / 100)
        this.props.navigator("/shopping/payment")
    }

    addTotalPrice(price: number) {
        this.setState({totalPrice: this.state.totalPrice + price})
    }

    render() {
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
                    this.state.cardItems.filter(item=>item.quantity > 0).map((item) => {
                        return <CardItemComponent addToPrice={this.addTotalPrice} item={item}/>
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
                    this.state.totalPrice
            } .-</span>
                <button onClick={this.goToPaymentPage} style={{marginLeft: 50, width: 100}} type="button"
                        className="btn btn-primary">buy
                </button>
            </div>
        </div>;
    }

}

export function ShoppingWithRouter(service: { eShopService: EShopService }) {
    let navigator = useNavigate();
    return <Shopping eShopService={service.eShopService} navigator={navigator}/>
}