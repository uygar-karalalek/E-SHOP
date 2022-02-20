import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBar} from "./sub_components/left/LeftBar";
import LoginWithRouter, {TokenAuthMethod} from "../login/Login";
import {NavigateFunction, useNavigate} from "react-router-dom";

export class Navigation {
    navigation: NavigateFunction

    constructor(navigation: NavigateFunction) {
        this.navigation = navigation
    }
}

interface HomeProps {
    navigation: Navigation,
    authentication: TokenAuthMethod
}

export class Home extends React.Component<HomeProps, {token: string}> {

    constructor(props: HomeProps) {
        super(props);
        this.state = {
            token: ""
        }
    }

    render() {
        if (this.props.authentication.getToken() == null || this.props.authentication.getToken() === "") {
            return <LoginWithRouter setToken={this.props.authentication.setToken} getToken={this.props.authentication.getToken} />
        }

        return <div className={"home-general container-fluid"}>
            <div className="row">
                <div className="col-12">
                    <UpperBar/>
                </div>
            </div>
            <div className="row">
                <div className="col-2">
                    <LeftBar />
                </div>
                <div className="home-center col-10">
                    <Center/>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <BottomBar/>
                </div>
            </div>
        </div>;
    }

}

export function HomeComponent(auth: TokenAuthMethod) {
    const navigation = useNavigate()
    return <Home navigation={new Navigation(navigation)} authentication={ auth } />;
}