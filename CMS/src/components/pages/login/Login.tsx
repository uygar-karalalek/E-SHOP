import * as React from "react";
import {ChangeEvent, Component} from "react";
import axios from "axios";
import {NavigateFunction, useNavigate} from "react-router-dom";

export interface Credentials {
    username: string,
    password: string
}

export class Login extends Component<{}, {}> {

    /**
     *
     * @param props
     * It seems we use bind(this) to initialize `this` inside the callback,
     * because of context changes...
     * the onclick method is specifically the cause of the change of the `this` context
     * that will no more refer to the class' `this, buth the onclick library `this (JS Global)`
     * but because the code is stricted,
     */
    constructor(props: any) {
        super(props);
        this.onChangeUsername = this.onChangeUsername.bind(this)
        this.onChangePassword = this.onChangePassword.bind(this)
        this.onSubmitForm = this.onSubmitForm.bind(this)
    }

    state = {
        username: "",
        password: ""
    }

    componentDidMount() {
        this.setState({username: "", password: ""})
    }

    onChangeUsername(event: ChangeEvent<HTMLInputElement>) {
        console.log(this.state.username);
        this.setState({username: event.target.value});
    }

    onChangePassword(event: ChangeEvent<HTMLInputElement>) {
        this.setState({password: event.target.value})
    }

    onSubmitForm(event: React.SyntheticEvent) {
        event.preventDefault();
        var value = this.loginUser({email: this.state.username, password: this.state.password})
    }

    async loginUser(credentials: { email: string, password: string }) {
        return await axios.post("/login", JSON.stringify(credentials), {headers: {'content-type': "application/json"}})
    }

    render() {

        return (
            <div style={{
                fontFamily: "Arial",
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                height: '100vh'
            }}>
                <div>
                    <label style={{marginBottom: 20, fontSize: "14pt", fontWeight: "bold"}}>Login</label>
                    <form onSubmit={this.onSubmitForm} >
                        <table style={{textAlign: "right", borderSpacing: "20px"}}>
                            <tr>
                                <td style={{marginRight: 10, paddingBottom: 10}}><label>Username:</label></td>
                                <td style={{padding: "0 0 10px 10px"}}>
                                    <input type={"text"} onChange={this.onChangeUsername}/>
                                </td>
                            </tr>
                            <tr>
                                <td style={{marginRight: 10, paddingBottom: 10}}><label>Password:</label></td>
                                <td style={{padding: "0 0 10px 10px"}}>
                                    <input type={"password"} onChange={this.onChangePassword}/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type={"submit"} value={"submit"} />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        );
    }

}

export default function LoginWithRouter(props: any) {
    const navigation = useNavigate()
    return <Login navigation={navigation}  {...props}/>
}