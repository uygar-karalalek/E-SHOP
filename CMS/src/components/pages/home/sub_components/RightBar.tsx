import * as React from "react";
import {Link} from "react-router-dom";

export class RightBar extends React.Component<{}, {}> {

    render() {
        return <div className={"container"} style={{backgroundColor: "darkslateblue"}}>
            <h3><Link to={"/login"}>Login</Link></h3>
            <br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
            Item<br/>
        </div>;
    }

}