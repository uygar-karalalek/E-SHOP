import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBarComponent} from "./sub_components/left/LeftBar";
import {NavigateFunction, Routes, useNavigate} from "react-router-dom";
import {ApplicationServices} from "../../../services/ApplicationServices";
import {Route} from "react-router";
import {UserOrders} from "../orders/UserOrders";

export class Navigation {
    navigation: NavigateFunction

    constructor(navigation: NavigateFunction) {
        this.navigation = navigation
    }
}

interface HomeProps {
    navigation: Navigation,
    appServices: ApplicationServices
}

export class Home extends React.Component<HomeProps, {}> {

    constructor(props: HomeProps) {
        super(props);
        this.setFilterTitle = this.setFilterTitle.bind(this)
    }

    render() {
        return <div className={"home-general container-fluid"}>
            <div className="row">
                <div className="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <UpperBar appServices={this.props.appServices} setTitleState={this.setFilterTitle}/>
                </div>
            </div>
            <div className="row">
                <div className="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                    <LeftBarComponent appServices={this.props.appServices}/>
                </div>
                <div className="home-center col-sm-10 col-md-10 col-lg-10 col-xl-10">
                    <Routes>
                        <Route path={"/"} element={<Center appServices={this.props.appServices}/>}/>
                        <Route path={"orders"} element={<UserOrders appServices={this.props.appServices}/>}/>
                    </Routes>
                </div>
            </div>
            <div className="row">
                <div className="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <BottomBar/>
                </div>
            </div>
        </div>;
    }

    setFilterTitle() {
        this.setState({})
    }

}

export function HomeComponent(props: { appServices: ApplicationServices }) {
    const navigation = useNavigate()
    return <Home appServices={props.appServices} navigation={new Navigation(navigation)}/>;
}