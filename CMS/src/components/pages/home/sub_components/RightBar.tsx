import * as React from "react";
import {Link} from "react-router-dom";

export class RightBar extends React.Component<{}, {}> {

    render() {
        return <div>
            right
            <Link to={"/login"} >Login</Link>
        </div>;
    }

}