import * as React from "react";
import '../res/css/App.css';
import SVG_Y from "../res/components/Logo"
import {useState, useEffect} from "react";
import {User} from "./api/EShopApi";
import axios, {AxiosResponse} from "axios";


function App() {
    const [userData, setUserData] = useState<User[]>([]);
    useEffect(() => {
        axios.get<User[]>("http://localhost:8081/users")
            .then((response: AxiosResponse) => {
                console.log("Response: ", response.data)
            })
    }, [])
  return (
      <div className="App">
        <header className="App-header">
          <SVG_Y width={50} height={50} />
        </header>
      </div>
  );
}

export default App;
