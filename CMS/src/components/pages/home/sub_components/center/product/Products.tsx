import * as React from "react";
import {Product} from "../../../../../../interfaces/Product";
import axios from "axios";
import {ProductComponent} from "./ProductComponent";

export class Products extends React.Component<{}, {}> {

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
        return (
            <div className="p-2 bd-highlight">
                {this.state.products.map((item) =>
                    <ProductComponent title={item.title} description={item.description} price={item.price} />
                )}
            </div>
        );
    }
}