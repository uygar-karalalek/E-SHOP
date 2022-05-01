import * as React from "react";
import {useEffect, useRef, useState} from "react";
import {useNavigate} from "react-router-dom";
import {ApplicationServices} from "../../../services/ApplicationServices";
import {Order} from "../../../interfaces/Order";
import {PayPalOrder} from "../../../interfaces/PayPalOrder";
import {Simulate} from "react-dom/test-utils";
import compositionStart = Simulate.compositionStart;

interface Props {
    currency: string,
    appServices: ApplicationServices
}

export const Checkout: (props: Props) => JSX.Element = (props: Props) => {

    const [priceState, setPrice] = useState({price: 0, priceLoaded: false})


    function updatePrice(computed: number) {
        setPrice({price: computed, priceLoaded: true})
    }

    props.appServices.userService.computeTotalUserPrice().then(computed => {
        let visualPrice = parseFloat(computed.toFixed(2));

        // So when we update the price and the state changes, the window reloads
        // without rendering two times the paypal buttons
        if (visualPrice !== priceState.price)
            updatePrice(visualPrice);
    })

    const paypal = useRef()

    useEffect(() => {
        if (priceState.priceLoaded) {
            // @ts-ignore
            window.paypal
                .Buttons({        // @ts-ignore
                        createOrder: function (data, actions) {
                            console.log("CREATING")
                            return actions.order.create({
                                intent: "CAPTURE",
                                purchase_units: [
                                    {
                                        description: "E-Shop payment",
                                        amount: {
                                            currency_code: "CHF",
                                            value: priceState.price,
                                        },

                                    }
                                ]
                            });
                        },
                        // @ts-ignore
                        onCancel: function (data) {
                            alert("NOOOO")
                        },
                        // @ts-ignore
                        onApprove: function (data, actions) {
                            props.appServices.paymentService.getPaypalOrder(data.orderID, data.facilitatorAccessToken)
                                .then((paypalOrder: PayPalOrder) => {
                                    console.log(paypalOrder)
                                    props.appServices.userService.getUserIdByStoredToken().then((userId: number) => {
                                        console.log(paypalOrder.amount + " - " + paypalOrder.shippingAddress + " - " + paypalOrder.receiverFullName)
                                        props.appServices.paymentService.addOrder(userId, {
                                            id: null,
                                            status: 0,
                                            userId: userId,
                                            receiverAddress: paypalOrder.shippingAddress,
                                            receiverFullName: paypalOrder.receiverFullName,
                                            totalPrice: paypalOrder.amount,
                                            dateAdded: null
                                        })
                                    });
                                })
                        },
                        onError: (err: any) => {
                            console.log("ERROR")
                            console.log(err)
                            //   window.location.href = "/";
                        },
                    }
                ).render(paypal.current);
        }
    }, [priceState, props]);

    return <div>
        <div style={{marginTop: 100, display: 'flex', justifyContent: 'center'}}>
            <div style={{
                marginTop: 100,
                display: "flex",
                justifyContent: "center",
                lineHeight: "100px",
                width: "48%",
                color: "white",
                fontSize: "25pt",
                fontFamily: "Arial",
                background: "#258aa2",
                height: "100px",
                borderColor: "#af5454",
                borderRadius: "3px",
                borderStyle: "solid"
            }}>
                Choose your payment method (
                <text style={{color: "#00ff00"}}>{priceState.price} {props.currency}</text>
                )
            </div>
        </div>
        <div style={{display: 'flex', justifyContent: 'center'}}>
            <div style={{marginTop: 100, width: "70%", display: 'flex', justifyContent: 'center'}} ref={paypal}></div>
        </div>
    </div>

}