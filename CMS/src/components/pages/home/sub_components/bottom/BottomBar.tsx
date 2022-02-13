import * as React from "react";

export class BottomBar extends React.Component<{}, {}> {

    render() {
        return <div style={{backgroundColor: "salmon"}}>
            <footer style={{color: "white"}} className="bg-dark text-center text-lg-start">
                <div className="container p-4">
                    <div className="row">

                        <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
                            <h5 className="text-uppercase">Sede</h5>

                            <ul className="list-unstyled mb-0">
                                <li>
                                    <text className="text-light">Via alla Morettina 3</text>
                                </li>
                                <li>
                                    <text className="text-light">6600 Locarno</text>
                                </li>
                                <li>
                                    <text className="text-light">+41 XX XXX XX XX</text>
                                </li>
                            </ul>
                        </div>



                        <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
                            <h5 className="text-uppercase mb-0">Settore sviluppo</h5>

                            <ul className="list-unstyled">
                                <li>
                                    <text className="text-light">Uygar Karalalek</text>
                                </li>
                                <li>
                                    <text className="text-light">Classe I4a</text>
                                </li>
                                <li>
                                    <text className="text-light">Modulo 150 (E-Commerce)</text>
                                </li>
                            </ul>
                        </div>
                        <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
                            <h5 className="text-uppercase">Orari d'apertura</h5>
                            <ul className="list-unstyled mb-0">
                                <li>
                                    <text className="text-light">8:00 - 12:00</text>
                                </li>
                                <li>
                                    <text className="text-light">13:00 - 18:00</text>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div className="text-center p-3" style={{backgroundColor: "rgba(0, 0, 0, 0.2)"}}>
                    © 2020 Copyright:
                    <a className="text-light" href="https://mdbootstrap.com/">MDBootstrap.com</a>
                </div>
            </footer>
        </div>;
    }

}