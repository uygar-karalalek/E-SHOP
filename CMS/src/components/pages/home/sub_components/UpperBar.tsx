import * as React from "react";

export class UpperBar extends React.Component<{}, {}> {

    render() {
        return <div style={{ backgroundColor: "salmon", padding: "10px" }}>
            <img width={120} src={"sample.png"} alt={"not_found"} />
            <span style={{ color: "white", paddingTop: 20, paddingLeft: 100 }}>Cerca</span>
            <input style={{ marginLeft: 20, width: 500 }} type={"text"} placeholder={"cerca nel db..."} />
            <input style={{ marginLeft: 20, width: 100 }} type={"button"} value={"OK"} />
        </div>;
    }

}