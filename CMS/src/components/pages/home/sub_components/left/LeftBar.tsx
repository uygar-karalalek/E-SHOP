import * as React from "react";
import {Link, useNavigate} from "react-router-dom";
import {EShopService} from "../../../../../services/EShopService";
import {User} from "../../../../../interfaces/User";

export interface Props {
    eShopService: EShopService
}

export class LeftBar extends React.Component<Props, { loginComponent: JSX.Element }> {

    state = {
        loginComponent: <span/>
    }

    constructor(props: any) {
        super(props);
    }

    componentDidMount() {
        if (this.props.eShopService.getToken() == null || this.props.eShopService.getToken().length == 0) {
            this.props.eShopService.createGuest(this.generateGuestName()).finally()
            this.setState({loginComponent: <Link to={"/login"}>Login</Link>})
        } else {
            this.props.eShopService.getUserByStoredToken().then(value => {
                    let user: User = JSON.parse(JSON.stringify(value.data))
                    if (user.guest) this.setState({loginComponent: <Link to={"/login"}>Login</Link>})
                }
            );
        }
    }

    render() {

        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            {this.state.loginComponent}
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
        </div>;
    }

    private generateGuestName(): string {
        let length = Math.round((Math.random() * 12) + 5)
        let randGuestName = "Guest";
        for (let i = 0; i < length; i++) {
            let maiusc = this.random(0, 2) == 0
            let code = 0;
            if (maiusc) code = this.random(65, 90)
            else code = this.random(97, 122)
            randGuestName += String.fromCharCode(code)
        }
        return randGuestName
    }

    random(min: number, max: number): number {
        return Math.round((Math.random() * (max - min)) + min)
    }

}

export function LeftBarComponent(props: { eShopService: EShopService }) {
    return <LeftBar eShopService={props.eShopService}/>;
}