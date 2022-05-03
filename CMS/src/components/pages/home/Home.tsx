import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBarComponent} from "./sub_components/left/LeftBar";
import {NavigateFunction, Routes, useNavigate} from "react-router-dom";
import {ApplicationServices} from "../../../services/ApplicationServices";
import {Route} from "react-router";
import {UserOrders} from "../orders/UserOrders";
import {Simulate} from "react-dom/test-utils";
import canPlayThrough = Simulate.canPlayThrough;
import {CardItem} from "../../../interfaces/CardItem";

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

/* TODO : THIS AWFUL MANAGEMENT OF APPLICATION STATE
    ACROSS UPPER BAR AND CENTER COMPONENTS WOULD BE REPLACED BY A BETTER ONE
    USING INSTEAD A CACHING SYSTEM SYSTEM LIKE REDUX OR REDIS
*/

export class Home extends React.Component<HomeProps, { cardItems: number }> {

    constructor(props: HomeProps) {
        super(props);
        this.filterTitleUpdate = this.filterTitleUpdate.bind(this)
        this.cartItemUpdate = this.cartItemUpdate.bind(this)
        this.updateHome = this.updateHome.bind(this)

        this.state = {
            cardItems: 0
        }
    }

    componentDidMount() {
        this.props.appServices.userService.getUserIdByStoredToken().then(userId => {
            this.props.appServices.shoppingCardService.getUserCardItems(userId).then((items: Array<CardItem>) =>
                this.setState({cardItems: items.length}))
        })
    }

    render() {
        return <div className={"home-general container-fluid"}>
            <div className="row">
                <div className="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <UpperBar numOfItems={this.state.cardItems == null ? 0 : this.state.cardItems} appServices={this.props.appServices}
                              setTitleState={this.filterTitleUpdate}/>
                </div>
            </div>
            <div className="row">
                <div className="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                    <LeftBarComponent appServices={this.props.appServices}/>
                </div>
                <div className="home-center col-sm-10 col-md-10 col-lg-10 col-xl-10">
                    <Routes>
                        <Route path={"/"} element={<Center numOfItems={this.state.cardItems == null ? 0 : this.state.cardItems}
                                                           cartUpdate={this.cartItemUpdate}
                                                           appServices={this.props.appServices}/>}/>
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

    cartItemUpdate(cardItems: number) {
        this.updateHomeCardItems(cardItems)
    }

    filterTitleUpdate() {
        this.updateHome();
    }

    private updateHomeCardItems(cardItems: number) {
        this.setState({cardItems: cardItems})
    }

    private updateHome() {
        this.setState({})
    }
}

export function HomeComponent(props: { appServices: ApplicationServices }) {
    const navigation = useNavigate()
    return <Home appServices={props.appServices} navigation={new Navigation(navigation)}/>;
}