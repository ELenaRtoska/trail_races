import React from "react";
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <Link className="navbar-brand" to={"/"}>Home</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"/>
                </button>
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item">
                            <Link className="nav-link" to={"/races"}>Races</Link>
                        </li>
                        <li className="nav-item ">
                            <Link className="nav-link" to={"/features"}>Features</Link>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

    );
};

export default Header;