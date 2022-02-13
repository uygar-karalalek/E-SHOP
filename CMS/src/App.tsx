import * as React from "react";
import {Component} from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import {ShoppingWithRouter} from "./components/pages/shopping/Shopping";
import LoginWithRouter from "./components/pages/login/Login";
import {Home} from "./components/pages/home/Home";
import {Checkout} from "./components/pages/shopping/Checkout";

export class App extends Component<{}, {}> {

    private priceToPay: number = 0

    constructor(props: any) {
        super(props);
        this.setPrice = this.setPrice.bind(this)
        this.getPrice = this.getPrice.bind(this)
    }

    render() {
        const token: any = this.getToken()
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={<Home/>}/>
                    <Route path={"/login"} element={<LoginWithRouter setToken={this.setToken}/>}/>
                    <Route path={"/shopping"} element={<ShoppingWithRouter setPrice={this.setPrice}/>}/>
                    <Route path={"/shopping/payment"}
                           element={<Checkout getPrice={this.getPrice} currency={"CHF"}/>}/>
                </Routes>
            </div>
        );
    }

    setToken(userToken: any) {
        sessionStorage.setItem("token", JSON.stringify(userToken))
    }

    getToken() {
        const tokenString = sessionStorage.getItem("token")
        const userToken = JSON.parse(tokenString)
        return userToken?.token
    }

    private setPrice(price: number) {
        this.priceToPay = price
    }

    private getPrice(): number {
        return this.priceToPay
    }

}