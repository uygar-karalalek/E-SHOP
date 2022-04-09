import * as React from "react";
import {Component, useRef} from "react";
import {CardItem} from "../../../interfaces/CardItem";
import {CardItemComponent} from "./CardItemComponent";
import {NavigateFunction, useNavigate} from "react-router-dom";
import {ApplicationServices} from "../../../services/ApplicationServices";
import {User} from "../../../interfaces/User";

interface Props {
    navigator: NavigateFunction,
    appServices: ApplicationServices
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
        this.props.appServices.userService.getUserIdByStoredToken().then((userId: number) => {
            this.props.appServices.shoppingCardService.getUserCardItems(userId).then((items: Array<CardItem>) => {
                this.setState({cardItems: items})
            })
        })
        this.props.appServices.userService.computeTotalUserPrice().then(price => {
            this.setState({totalPrice: price})
        });
    }

    goToPaymentPage() {
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
                    this.state.cardItems.filter(item => item.quantity > 0).map((item) => {
                        return <CardItemComponent appServices={this.props.appServices} addToPrice={this.addTotalPrice}
                                                  item={item}/>
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

export function ShoppingWithRouter(service: { appServices: ApplicationServices }) {
    let navigator = useNavigate();
    return <Shopping appServices={service.appServices} navigator={navigator}/>
}