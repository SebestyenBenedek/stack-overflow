import React from "react";
import "./SearchBox.css"; // Import your CSS file for custom styles

const SearchBox = () => {

    return (
        <div className="search-box">
            <div className="control has-icons-left has-icons-right">
                <input className="input is-rounded search-bar" type="search" placeholder="Search" />
                <span className="icon is-small is-left">
                    <i className="fa-solid fa-magnifying-glass"></i>
                </span>
                <button className="button is-rounded is-primary ml-2" type="submit">Search!</button>
            </div>
        </div>
    );
};

export default SearchBox;
