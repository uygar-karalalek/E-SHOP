import * as React from "react";
import {Component} from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import {ShoppingWithRouter} from "./components/pages/shopping/Shopping";
import LoginWithRouter from "./components/pages/login/Login";
import {HomeComponent} from "./components/pages/home/Home";
import {Checkout} from "./components/pages/shopping/Checkout";
import {ApplicationServices} from "./services/ApplicationServices";

export class App extends Component<{}, {}> {

    applicationServices: ApplicationServices = new ApplicationServices();

    constructor(props: any) {
        super(props);
    }

    render() {
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={<HomeComponent appServices={this.applicationServices} />}/>

                    <Route path={"/login"}
                           element={<LoginWithRouter appServices={this.applicationServices} />}/>

                    <Route path={"/shopping"} element={<ShoppingWithRouter appServices={this.applicationServices} />}/>

                    <Route path={"/shopping/payment"}
                           element={<Checkout appServices={this.applicationServices} currency={"CHF"}/>}/>
                </Routes>
            </div>
        );
    }

}