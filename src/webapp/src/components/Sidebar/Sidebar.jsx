import React from "react";
import "./Sidebar.css";
import Question from "../Question/Question"; // Import your CSS file for custom styles

const Sidebar = ({ tagList }) => {

    return (
        <div className="sidebar-content">
            <h1 className="title is-5">Most popular tags</h1>
            <hr className="hr-style"/>
            <div>
                {tagList.map((tag) => {
                    return (
                        <span className="tag is-rounded m-1">
                            <span className="icon">
                                <i className="fa-solid fa-hashtag"></i>
                            </span>
                            <strong>{tag}</strong>
                        </span>
                    )
                })}
            </div>
        </div>
    );
};

export default Sidebar;
