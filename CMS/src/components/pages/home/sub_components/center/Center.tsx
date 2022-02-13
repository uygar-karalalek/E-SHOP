import * as React from "react";
import axios from 'axios';
import {ProductComponent} from "./product/ProductComponent";
import {Product} from "../../../../../interfaces/Product";
import {ProductDetailsComponent} from "./product/ProductDetailsComponent";


export class Center extends React.Component<{}, { products: Array<Product>, product?: Product }> {

    constructor(props: {}) {
        super(props);
        this.productsOrDetails = this.productsOrDetails.bind(this);
        this.setViewProductDetails = this.setViewProductDetails.bind(this);
        this.state = {
            products: Array<Product>(),
            product: null
        }
    }

    productsOrDetails(product: Product) {
        if (product != null)
            return <ProductDetailsComponent setViewProductDetails={this.setViewProductDetails} product={product} />
        return <div className="d-flex flex-wrap">
            {this.state.products.map((item) => {
                return <ProductComponent setViewProductDetails={this.setViewProductDetails} product={item}/>
            })}
        </div>
    }

    componentDidMount() {
        axios.get('/products')
            .then(res => {
                const items = res.data;
                this.setState({products: items});
            })
    }

    render() {
        const prodDetails = this.state.product
        return <div className={"container"} style={{backgroundColor: "rgb(33, 33, 37)", padding: 10}}>
            {this.productsOrDetails(prodDetails)}
        </div>;
    }

    setViewProductDetails(product: Product) {
        this.setState({product: product})
    }

}