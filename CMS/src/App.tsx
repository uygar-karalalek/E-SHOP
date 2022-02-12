import * as React from "react";
import {Component} from "react";
import {Routes, useNavigate} from "react-router-dom";
import {Route} from "react-router";
import {Home} from "./components/pages/home/Home";
import {Shopping} from "./components/pages/shopping/Shopping";
import LoginWithRouter from "./components/pages/login/Login";
import {Checkout} from "./components/pages/shopping/Checkout";

export class App extends Component<{}> {

    render() {
        const token: any = this.getToken()
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={ <Checkout /> } />
                    <Route path={"/login"} element={ <LoginWithRouter setToken={ this.setToken } /> } />
                    <Route path={"/shopping"} element={ <Shopping /> } />
                </Routes>
            </div>
        );
    }

    setToken(userToken: any) {
        console.log("setting token")
        sessionStorage.setItem("token", JSON.stringify(userToken))
    }

    getToken() {
        const tokenString = sessionStorage.getItem("token")
        const userToken = JSON.parse(tokenString)
        return userToken?.token
    }

}