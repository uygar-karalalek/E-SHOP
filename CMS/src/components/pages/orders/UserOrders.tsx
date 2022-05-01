import {ApplicationServices} from "../../../services/ApplicationServices";
import * as React from "react";
import {Order} from "../../../interfaces/Order";
import {OrderProduct} from "../../../interfaces/OrderProduct";

export interface Props {
    appServices: ApplicationServices
}

export class UserOrders extends React.Component<Props, { orders: Array<Order> }> {

    constructor(props: Props) {
        super(props);
        this.state = {
            orders: Array<Order>()
        }
    }

    componentDidMount() {
        this.props.appServices.userService.getUserIdByStoredToken().then((userId: number) => {
            return this.props.appServices.paymentService.getUserOrders(userId)
        }).then((orders: Array<Order>) => {
            this.setState({orders: orders});
        })
    }

    render() {
        return <div className={"container"} style={{height: 600, backgroundColor: "rgb(33, 33, 37)", color: "white"}}>
            <h1>Your orders</h1>
            {
                this.state.orders.map(item => {

                    return <div>
                        <h4>ID {item.id}</h4><br />

                        <h5>Articles: </h5>{
                            item.orderProducts.map((related: OrderProduct) => {
                                return <>{related.productTitle}</>
                            })
                        }
                    </div>
                })
            }

        </div>
    }

}