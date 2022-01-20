import * as React from "react";
import axios from 'axios';
import {Card} from "react-bootstrap";
import {Product} from "../../../../interfaces/Product";

export class Center extends React.Component<{}, {}> {

    state = {
        products: Array<Product>()
    }

    componentDidMount() {
        axios.get('/products')
            .then(res => {
                const persons = res.data;
                console.log(persons)
                this.setState({persons});
            })
    }

    render() {
        return <div className={"container"} style={{backgroundColor: "lightblue"}}>
            <div className="d-flex flex-wrap">

                {this.state.products.map((item) => {
                    return
                })}
            </div>
        </div>;
    }

}