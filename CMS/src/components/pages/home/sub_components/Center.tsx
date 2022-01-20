import * as React from "react";
import axios from 'axios';

export class Center extends React.Component<{}, {}> {

    state = {
        persons: Array<any>()
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
        return <div className={"container"} style={{backgroundColor: "blueviolet"}}>
            <div className="d-flex flex-wrap">
                {this.state.persons.map((item) => {
                    return <div className="p-2 bd-highlight">Flex item with price {item.price}</div>
                })}
            </div>
        </div>;
    }

}