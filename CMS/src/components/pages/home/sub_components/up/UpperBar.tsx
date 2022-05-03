import * as React from "react";
import {Link} from "react-router-dom";
import {ApplicationServices} from "../../../../../services/ApplicationServices";

export class UpperBar extends React.Component<{
    appServices: ApplicationServices,
    setTitleState: any,
    numOfItems: number
}> {

    filterTitle: string

    constructor(props: any) {
        super(props);
        this.inputValueChange = this.inputValueChange.bind(this)
        this.changeFiltering = this.changeFiltering.bind(this)
    }

    render() {
        return <div className={"upper-side"}>
            <img width={120} src={"sample.png"} alt={"not_found"}/>
            <span className={"search-label"}>Cerca</span>
            <input style={{ width: "40%" }} onChange={this.inputValueChange} className={"search-bar"} type={"text"} placeholder={"cerca nel db..."}/>
            <input className={"upper-ok-button"} type={"button"} value={"OK"} onClick={this.changeFiltering}/>
            <Link to={"/shopping"}><img className={"upper-shopping-link"} width={50} src={"shopping_card.png"}
                                        alt={"not_found"}/></Link>
            <span style={{ color: "white" }}>{ this.props.numOfItems }</span>
        </div>;
    }

    inputValueChange(event: any) {
        console.log(event.target.value)
        this.filterTitle = event.target.value
    }

    changeFiltering() {
        this.props.appServices.filterService.setProductTitleFilter(this.filterTitle)
        this.props.setTitleState()
    }

}