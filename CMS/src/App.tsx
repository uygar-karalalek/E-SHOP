import * as React from "react";
import {Component} from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import {ShoppingWithRouter} from "./components/pages/shopping/Shopping";
import LoginWithRouter from "./components/pages/login/Login";
import {HomeComponent} from "./components/pages/home/Home";
import {Checkout} from "./components/pages/shopping/Checkout";
import {EShopService} from "./services/EShopService";

export class App extends Component<{}, {}> {

    eShopService: EShopService = new EShopService();

    constructor(props: any) {
        super(props);
    }

    render() {
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={<HomeComponent eShopService={this.eShopService} />}/>

                    <Route path={"/login"}
                           element={<LoginWithRouter eShopService={this.eShopService} />}/>

                    <Route path={"/shopping"} element={<ShoppingWithRouter eShopService={this.eShopService} />}/>

                    <Route path={"/shopping/payment"}
                           element={<Checkout eShopService={this.eShopService} currency={"CHF"}/>}/>
                </Routes>
            </div>
        );
    }

}