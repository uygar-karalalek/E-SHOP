import * as React from "react";
import {Link, useNavigate} from "react-router-dom";
import {UserService} from "../../../../../services/UserService";
import {User} from "../../../../../interfaces/User";
import {ApplicationServices} from "../../../../../services/ApplicationServices";

export interface Props {
    appServices: ApplicationServices
}

export class LeftBar extends React.Component<Props, { loginElement: JSX.Element }> {

    state = {
        loginElement: <span/>
    }

    constructor(props: any) {
        super(props);
    }

    componentDidMount() {
        if (this.props.appServices.cookieService.getToken() == null || this.props.appServices.cookieService.getToken().length == 0) {
            this.props.appServices.userService.createGuest(this.generateGuestName()).finally(() => {
                this.setState({loginElement: <Link to={"/login"}>Login</Link>})
            })
        } else {
            this.props.appServices.userService.getUserByStoredToken().then(user => {
                    if (user.guest)
                        this.setState({loginElement: <Link to={"/login"}>Login</Link>})
                }
            );
        }
    }

    render() {
        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            {this.state.loginElement}
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

export function LeftBarComponent(props: { appServices: ApplicationServices }) {
    return <LeftBar appServices={props.appServices}/>;
}