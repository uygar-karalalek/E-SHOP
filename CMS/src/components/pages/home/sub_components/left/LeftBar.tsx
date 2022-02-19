import * as React from "react";
import {Link} from "react-router-dom";

export class LeftBar extends React.Component<{}, {}> {

    constructor(props: any) {
        super(props);
    }

    render() {
        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            <Link to={"/login"}>Login</Link>
            <br/>
            <h4>Web Shop article types</h4><br/>
            <ul>
                <li>
                    Programming books<br/>
                </li>
                <li>
                    Philosophy books<br/>
                </li>
                <li>
                    Novels<br/>
                </li>
                <li>
                    Poetry books<br/>
                </li>
                <li>
                    Arduino books (soon)<br/>
                </li>
            </ul>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
        </div>;
    }

}