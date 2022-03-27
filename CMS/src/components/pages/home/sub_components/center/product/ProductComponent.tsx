import * as React from "react";
import {Card} from "react-bootstrap";
import {Product} from "../../../../../../interfaces/Product";
import {ApplicationServices} from "../../../../../../services/ApplicationServices";
import {User} from "../../../../../../interfaces/User";

export class ProductComponent extends React.Component<{
    product: Product,
    setViewProductDetails: (det: Product) => void,
    appServices: ApplicationServices
}, {}> {

    constructor(props: any) {
        super(props);
        this.addProductToCard = this.addProductToCard.bind(this)
        this.setProductForViewDetails = this.setProductForViewDetails.bind(this);
    }

    setProductForViewDetails() {
        this.props.setViewProductDetails(this.props.product)
    }

    render() {
        return (
            <Card style={{width: '15rem', marginRight: 10, marginTop: 10, backgroundColor: "#545f6b", color: "white"}}>
                <Card.Body>
                    <div>
                        <Card.Img onClick={this.setProductForViewDetails} style={{
                            borderColor: "red",
                            borderStyle: "solid",
                            marginBottom: '2rem',
                            width: "100%",
                            height: "10vw",
                            objectFit: "cover"
                        }} src={"sample.png"}/>
                        <label style={{
                            overflow: "hidden",
                            textAlign: "left",
                            marginBottom: "2rem",
                            height: 70
                        }}>{this.props.product.title}</label>
                        <Card.Text style={{
                            fontWeight: "bold",
                            color: "#5db453",
                            height: 10,
                            marginBottom: 30
                        }}>{this.props.product.price} CHF</Card.Text>
                        <button onClick={this.addProductToCard}>Buy</button>
                    </div>
                </Card.Body>
            </Card>
        );
    }

    addProductToCard(event: React.MouseEvent<HTMLElement>) {
        let userService = this.props.appServices.userService;
        let shoppingCardService = this.props.appServices.shoppingCardService;

        userService.getUserByStoredToken().then((user: User) => {
            let productToAdd = this.props.product;
            let cardId = user.shoppingCard.id;
            console.log(JSON.stringify(user))
            shoppingCardService.addProductToCard(cardId, productToAdd).then(product => {
                this.setState({product})
            });
        })
    }

}