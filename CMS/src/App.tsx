import * as React from "react";
import {Component} from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import {ShoppingWithRouter} from "./components/pages/shopping/Shopping";
import LoginWithRouter, {Authentication} from "./components/pages/login/Login";
import {HomeComponent} from "./components/pages/home/Home";
import {Checkout} from "./components/pages/shopping/Checkout";

export class App extends Component<{}, {}> {

    private priceToPay: number = 0

    constructor(props: any) {
        super(props);
        this.setPrice = this.setPrice.bind(this)
        this.getPrice = this.getPrice.bind(this)

        this.setToken = this.setToken.bind(this);
        this.getToken = this.getToken.bind(this);
    }

    render() {
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={<HomeComponent setToken={this.setToken}  getToken={this.getToken}/>}/>
                    <Route path={"/login"} element={<LoginWithRouter setToken={this.setToken} getToken={this.getToken}/>}/>
                    <Route path={"/shopping"} element={<ShoppingWithRouter setPrice={this.setPrice}/>}/>
                    <Route path={"/shopping/payment"} element={<Checkout getPrice={this.getPrice} currency={"CHF"}/>}/>
                </Routes>
            </div>
        );
    }

    setToken(userToken: any) {
        console.log("Setting token " + userToken)
        sessionStorage.setItem("token", JSON.stringify(userToken))
    }

    getToken(): string {
        const tokenString = sessionStorage.getItem("token")
        console.log("Getting token " + tokenString)
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