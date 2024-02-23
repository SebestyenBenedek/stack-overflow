import React, {useEffect, useState} from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";

const Navbar = () => {
    const [isNavOpen, setIsNavOpen] = useState(false);
    const [isLoggedIn, setIsLoggedIn] = useState(null);

    const navToggle = () => {
        setIsNavOpen(!isNavOpen);
    }

    const navRender = () => {
        return isNavOpen ? "navbar-menu is-active" : "navbar-menu";
    }

    const burgerRender = () => {
        return isNavOpen ? "navbar-burger is-active" : "navbar-burger";
    }

    useEffect(() => {
        localStorage.getItem('token') ? setIsLoggedIn(true) : setIsLoggedIn(false);
    }, [isLoggedIn]);

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
                        {isLoggedIn ?
                            <Link to={"/questions/create"} className="navbar-item">
                                Ask a question!
                            </Link>
                            :
                            <a className="navbar-item" onClick={() => alert("Log in first!")}>
                                Ask a question!
                            </a>
                        }
                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            {isLoggedIn ?
                                <div className="buttons">
                                    <button className="button is-light is-rounded"
                                        onClick={() => {
                                            localStorage.removeItem('token')
                                            setIsLoggedIn(!isLoggedIn);
                                        }} >
                                        <span className="icon">
                                            <i className="fas fa-sign-out-alt"></i>
                                          </span>
                                        <span>Logout</span>
                                    </button>
                                </div>
                                :
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
                            }
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    );
};

export default Navbar;
