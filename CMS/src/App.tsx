import * as React from "react";
import {Component} from "react";
import {Link, Routes} from "react-router-dom";
import {Route} from "react-router";
import {Home} from "./components/pages/home/Home";
import {Login} from "./components/pages/login/Login";
import {Shopping} from "./components/pages/shopping/Shopping";

export class App extends Component<{}> {

    render() {
        return (
            <div>
                <Routes>
                    <Route path={"/"} element={ <Home /> } />
                    <Route path={"/login"} element={ <Login /> } />
                    <Route path={"/shopping"} element={ <Shopping /> } />
                </Routes>
            </div>
        );
    }

}
