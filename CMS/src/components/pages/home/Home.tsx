import * as React from "react";
import {UpperBar} from "./sub_components/up/UpperBar";
// import {RightBar} from "./sub_components/right/RightBar";
import {Center} from "./sub_components/center/Center";
import {BottomBar} from "./sub_components/bottom/BottomBar";
import {LeftBar} from "./sub_components/left/LeftBar";

export class Home extends React.Component<{}, {}> {

    render() {
        return <div className={"container-fluid"} style={{backgroundColor: "rgba(33, 43, 37)"}}>
            <div className="row">
                <div className="col-12">
                    <UpperBar/>
                </div>
            </div>
            <div className="row">
                <div className="col-2">
                    <LeftBar/>
                </div>
                <div className="col-10" style={{padding: 10, paddingBottom: 30}}>
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