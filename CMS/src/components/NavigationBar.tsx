import * as React from "react";
import {BrowserRouter, NavLink, Router} from "react-router-dom";

export default class NavigationBar extends React.Component <{}> {

    render() {
        return (
            <BrowserRouter>
                <NavLink to="/about">About</NavLink>
            </BrowserRouter>
        );
    }

}