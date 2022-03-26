import * as React from "react";
import {Link, useNavigate} from "react-router-dom";
import {EShopService} from "../../../../../services/EShopService";

export interface Props {
    eShopService: EShopService
}

export class LeftBar extends React.Component<Props, {}> {

    constructor(props: any) {
        super(props);
    }

    render() {
        let login: JSX.Element = <span />;
        console.log(this.props.eShopService.getUserByStoredToken())
        if(this.props.eShopService.getUserByStoredToken().guest) {
            login = <Link to={"/login"}>Login</Link>
        }
        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            { login }
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

export function LeftBarComponent(props: { eShopService: EShopService }) {
    const navigation = useNavigate()
    return <LeftBar eShopService={props.eShopService} />;
}