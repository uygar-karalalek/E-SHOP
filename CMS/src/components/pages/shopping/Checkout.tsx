import * as React from "react";
import {useEffect, useRef} from "react";

export const Checkout: React.FunctionComponent = props => {

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
                                description: "Cool looking table",
                                amount: {
                                    currency_code: "CHF",
                                    value: 650.0,
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
        ciao
        <div ref={paypal}></div>
    </div>

}