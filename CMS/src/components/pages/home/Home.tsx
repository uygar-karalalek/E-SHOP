import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBar} from "./sub_components/left/LeftBar";
import {NavigateFunction, useNavigate} from "react-router-dom";

export class Navigation {
    navigation: NavigateFunction

    constructor(navigation: NavigateFunction) {
        this.navigation = navigation
    }
}

interface HomeProps {
    navigation: Navigation
}

export class Home extends React.Component<HomeProps, {}> {

    constructor(props: HomeProps) {
        super(props);
    }

    render() {
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

export function HomeComponent() {
    const navigation = useNavigate()
    return <Home navigation={new Navigation(navigation)} />;
}