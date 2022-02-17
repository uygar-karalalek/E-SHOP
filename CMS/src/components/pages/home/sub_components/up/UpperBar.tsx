import * as React from "react";
import {Link} from "react-router-dom";

export class UpperBar extends React.Component<{}, {}> {

    render() {
        return <div className={"upper-side"}>
            <img width={120} src={"sample.png"} alt={"not_found"} />
            <span className={"search-label"}>Cerca</span>
            <input className={"search-bar"} type={"text"} placeholder={"cerca nel db..."} />
            <input className={"upper-ok-button"} type={"button"} value={"OK"} />
            <Link to={"/shopping"}><img className={"upper-shopping-link"} width={50} src={"shopping_card.png"} alt={"not_found"} /></Link>
        </div>;
    }

}