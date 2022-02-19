import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBar} from "./sub_components/left/LeftBar";
import {Authentication, Login} from "../login/Login";
import {NavigateFunction, useNavigate} from "react-router-dom";

export class Navigation {
    navigation: NavigateFunction

    constructor(navigation: NavigateFunction) {
        this.navigation = navigation
    }
}

interface HomeProps {
    navigation: Navigation,
    authentication: Authentication
}

export class Home extends React.Component<HomeProps, {}> {

    constructor(props: HomeProps) {
        super(props);
    }

    render() {
        if (this.props.authentication.getToken() == null || this.props.authentication.getToken() === "") {
            return <Login authentication={this.props.authentication} navigation={this.props.navigation} />
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

export function HomeComponent(auth: Authentication) {
    const navigation = useNavigate()
    console.log(auth.getToken() + " << fake getting")
    return <Home navigation={new Navigation(navigation)} authentication={auth} />;
}