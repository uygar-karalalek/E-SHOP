import * as React from "react";
import axios from 'axios';
import {ProductComponent} from "./product/ProductComponent";
import {Product} from "../../../../../interfaces/Product";

export class Center extends React.Component<{}, {}> {

    state = {
        products: Array<Product>()
    }

    componentDidMount() {
        axios.get('/products')
            .then(res => {
                const items = res.data;
                this.setState({products: items});
            })
    }

    render() {
        return <div className={"container"} style={{backgroundColor: "lightblue"}}>
            <div className="d-flex flex-wrap">
                {this.state.products.map((item) => {
                    return <ProductComponent title={item.title} description={item.description} price={item.price} />
                })}
            </div>
        </div>;
    }

}