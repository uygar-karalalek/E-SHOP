import * as React from "react";
import {Link} from "react-router-dom";

export class RightBar extends React.Component<{}, {}> {

    render() {
        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            <br/>
            <h3><Link to={"/login"}>Do Login</Link></h3>
            <br/>
            <h4>Current functionalities</h4><br/>
            <ul>
                <li>
                    Add an article to cart<br/>
                </li>
                <li>
                    View article details<br/>
                </li>
                <li>
                    Add article from article details<br/>
                </li>
                <li>
                    Go to shopping cart<br/>
                </li>
                <li>
                    Make your payment<br/>
                </li>
            </ul>
        </div>;
    }

}