import * as React from "react";
import {UpperBar} from "./sub_components/UpperBar";
import {RightBar} from "./sub_components/RightBar";
import {Center} from "./sub_components/Center";
import {BottomBar} from "./sub_components/BottomBar";
import {LeftBar} from "./sub_components/LeftBar";

export class Home extends React.Component<{}, {}> {

    render() {
        return <div>
            <UpperBar />
            <RightBar />
            <Center />
            <BottomBar />
            <LeftBar />
        </div>;
    }

}