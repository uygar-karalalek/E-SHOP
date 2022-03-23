import * as React from "react";
import {Component} from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import {ShoppingWithRouter} from "./components/pages/shopping/Shopping";
import LoginWithRouter, {TokenAuthMethod} from "./components/pages/login/Login";
import {HomeComponent} from "./components/pages/home/Home";
import {Checkout} from "./components/pages/shopping/Checkout";
import {ShoppingService} from "./services/ShoppingService";

export class App extends Component<{}, {}> {

    shoppingService: ShoppingService = new ShoppingService();

    constructor(props: any) {
        super(props);
    }

    render() {
        if (this.shoppingService.getToken() == null || this.shoppingService.getToken().length == 0) {
            let guestName = this.generateGuestName();

        }
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={<HomeComponent/>}/>
                    <Route path={"/login"}
                           element={<LoginWithRouter />}/>
                    <Route path={"/shopping"} element={<ShoppingWithRouter />}/>
                    <Route path={"/shopping/payment"}
                           element={<Checkout currency={"CHF"}/>}/>
                </Routes>
            </div>
        );
    }

    private generateGuestName(): string {
        let length = Math.round((Math.random() * 12) + 5)
        let randGuestName = "Guest";
        for (let i = 0; i < length; i++) {
            let maiusc = this.random(0, 2) == 0
            let code = 0;
            if (maiusc) code = this.random(65, 90)
            else code = this.random(97, 122)
            randGuestName += String.fromCharCode(code)
        }
        return randGuestName
    }

    random(min: number, max: number): number {
        return Math.round((Math.random() * (max - min)) + min)
    }

}