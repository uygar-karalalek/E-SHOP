import * as React from "react";
import {useEffect, useRef} from "react";

interface Props {
    currency: string,
    getPrice: () => number
}

export const Checkout: (props: Props) => JSX.Element = (props: Props) => {

    // TODO : Knowing how to make getPrice more flexible
    const price = props.getPrice()
    const paypal = useRef()
    useEffect(() => {
        // @ts-ignore
        window.paypal
            .Buttons({
                createOrder: (data: any, actions: any) => {
                    return actions.order.create({
                        intent: "CAPTURE",
                        purchase_units: [
                            {
                                description: "E-Shop payment",
                                amount: {
                                    currency_code: props.currency,
                                    value: price,
                                },
                            },
                        ],
                    });
                },
                onApprove: async (data: any, actions: any) => {
                    const order = await actions.order.capture();
                    console.log(order);
                },
                onError: (err: any) => {
                    console.log(err);
                },
            })
            .render(paypal.current);
    }, []);
    useEffect(() => {})
    return <div>
        <div style={{marginTop: 100, display: 'flex', justifyContent: 'center'}}>
            <div style={{marginTop: 100,
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
                Choose your payment method (<text style={{color:"#00ff00"}}>{price}</text><span>&nbsp;</span>CHF)
            </div>
        </div>
        <div style={{display: 'flex', justifyContent: 'center'}}>
        <div style={{marginTop: 100, width: "70%", display: 'flex', justifyContent: 'center'}} ref={paypal}></div>
    </div></div>

}