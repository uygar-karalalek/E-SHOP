import * as React from "react";
import {UpperBar} from "./sub_components/UpperBar";
import {RightBar} from "./sub_components/RightBar";
import {Center} from "./sub_components/Center";
import {BottomBar} from "./sub_components/BottomBar";
import {LeftBar} from "./sub_components/LeftBar";

export class Home extends React.Component<{}, {}> {

    render() {
        return <div className={"container-fluid"}>
            <div className="row">
                <div className="col-12">
                    <UpperBar/>
                </div>
            </div>
            <div className="row">
                <div className="col-2">
                    <LeftBar/>
                </div>
                <div className="col-8">
                    <Center/>
                </div>
                <div className="col-2">
                    <RightBar/>
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