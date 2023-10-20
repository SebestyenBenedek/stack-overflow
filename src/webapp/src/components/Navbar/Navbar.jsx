import React, {useState} from "react";
import "./Navbar.css"; // Import your CSS file for custom styles

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
                    <a className="navbar-item" href="/">
                        <b>Mikéne?</b>
                    </a>

                    <a role="button" className={burgerRender()} aria-label="menu" aria-expanded="false" data-target="navbarItems" onClick={() => navToggle()}>
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                    </a>
                </div>

                <div id="navbarItems" className={navRender()}>
                    <div className="navbar-start">

                        <a className="navbar-item">
                            Questions
                        </a>

                        <a href={"/questions/create"} className="navbar-item">
                            Ask a question!

                        </a>

                    </div>

                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">
                                <a>
                                    <span className="icon-text button is-primary is-rounded mr-2">
                                      <span className="icon">
                                        <i className="fa-solid fa-user-plus"></i>
                                      </span>
                                      <span>Sign up!</span>
                                    </span>
                                </a>
                                <a>
                                    <button className="button is-light is-rounded">
                                        Log in
                                    </button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    );
};

export default Navbar;
