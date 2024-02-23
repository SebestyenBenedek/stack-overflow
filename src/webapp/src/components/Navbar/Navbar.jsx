import React, {useState} from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";

const Navbar = () => {
    const [isNavOpen, setIsNavOpen] = useState(false);

    const navToggle = () => {
        setIsNavOpen(!isNavOpen);
    }

    const navRender = () => {
        return isNavOpen ? "navbar-menu is-active" : "navbar-menu";
    }

    const burgerRender = () => {
        return isNavOpen ? "navbar-burger is-active" : "navbar-burger";
    }


    return (
        <div>
            <nav className="navbar" role="navigation" aria-label="main navigation">
                <div className="navbar-brand">
                    <Link className="navbar-item" to="/">
                        <b>What are you looking for?</b>
                    </Link>

                    <div role="button" className={burgerRender()} aria-label="menu" aria-expanded="false" data-target="navbarItems" onClick={() => navToggle()}>
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                    </div>
                </div>

                <div id="navbarItems" className={navRender()}>
                    <div className="navbar-start">

                        {/*<Link to={'/'} className="navbar-item">
                            Questions
                        </Link>*/}

                        <Link to={"/questions/create"} className="navbar-item">
                            Ask a question!
                        </Link>

                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">
                                <Link to={'/registration'}>
                                    <span className="icon-text button is-primary is-rounded mr-2">
                                      <span className="icon">
                                        <i className="fa-solid fa-user-plus"></i>
                                      </span>
                                      <span>Sign up!</span>
                                    </span>
                                </Link>
                                <Link to={'/login'}>
                                    <button className="button is-light is-rounded">
                                        Log in
                                    </button>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    );
};

export default Navbar;
