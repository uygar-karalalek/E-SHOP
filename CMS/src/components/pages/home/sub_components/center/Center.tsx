import * as React from "react";
import {ProductComponent} from "./product/ProductComponent";
import {Product} from "../../../../../interfaces/Product";
import {ProductDetailsComponent} from "./product/ProductDetailsComponent";
import {ApplicationServices} from "../../../../../services/ApplicationServices";

export class Center extends React.Component<{ appServices: ApplicationServices, cartUpdate: any, numOfItems: number }, {
    products: Array<Product>, product?: Product
}> {

    constructor(props: { appServices: ApplicationServices, cartUpdate: any, numOfItems: number }) {
        super(props);
        this.productsOrDetails = this.productsOrDetails.bind(this);
        this.setViewProductDetails = this.setViewProductDetails.bind(this);
        this.state = {
            products: Array<Product>(),
            product: null,
        }
    }

    productsOrDetails(product: Product) {
        if (product != null)
            return <ProductDetailsComponent numOfItems={this.props.numOfItems} cartUpdate={this.props.cartUpdate} appServices={this.props.appServices}
                                            setViewProductDetails={this.setViewProductDetails} product={product}/>
        return <div className="d-flex flex-wrap">
            {this.state.products.filter(prod => prod.title
                .includes(this.props.appServices.filterService.appServices.filterService.filter.productTitle)).map((item) => {
                return <ProductComponent numOfItems={this.props.numOfItems} cartUpdate={this.props.cartUpdate} appServices={this.props.appServices}
                                         setViewProductDetails={this.setViewProductDetails} product={item}/>
            })}
        </div>
    }

    componentDidMount() {
        this.props.appServices.filterService.getProductTitleFiltered()
            .then(items => this.setState({products: items}))
    }

    render() {
        console.log("RENDER!")
        const prodDetails = this.state.product
        return <div className={"container"} style={{backgroundColor: "rgb(33, 33, 37)"}}>
            {this.productsOrDetails(prodDetails)}
        </div>;
    }

    setViewProductDetails(product: Product) {
        this.setState({product: product})
    }

}