import * as React from "react";
import * as ReactDOM from "react-dom";
import FirstComponent from './components/FirstComponent'
import {UserComponent} from "./components/UserComponent";
import {Example} from "./Example";

ReactDOM.render(
    <div>
        <h1>Hello, Welcome to React and TypeScript</h1>
        <FirstComponent/>
        <Example/>
        <UserComponent name="Uygar Karalalek" age={20} address="Via Gelusa 1" dob={new Date()}/>
    </div>,
    document.getElementById("root")
);