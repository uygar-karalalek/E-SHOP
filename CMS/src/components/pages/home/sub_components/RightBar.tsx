import * as React from "react";
import {Link} from "react-router-dom";

export class RightBar extends React.Component<{}, {}> {

    render() {
        return <div style={{backgroundColor: "darkslateblue"}}>
            right
            <Link to={"/login"} >Login</Link>
        </div>;
    }

}