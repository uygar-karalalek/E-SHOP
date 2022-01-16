import * as React from "react";
import {HashRouter} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import {App} from "./App";

import("react-dom").then(dom => {
    dom.render(
        <HashRouter>
            <App/>
        </HashRouter>,
        document.getElementById("root")
    );
})