import * as React from "react";
import { useState, useEffect } from 'react';
import axios, {AxiosResponse} from "axios";

interface User {
    id: number
}

export function Example() {
    const [count, setCount] = useState(0);
    // Similar to componentDidMount and componentDidUpdate:
    useEffect(() => {
        axios.get<User[]>("http://localhost:8081/users")
            .then((response: AxiosResponse) => {
                let resData = response.data;
                console.log("Response: ", resData);
            })
    }, [])

    return (
        <div>
            <p>You clicked times</p>
        </div>
    );
}
