import React, {useState} from "react";
import "./HomePage.css"; // Import your CSS file for custom styles
import Navbar from "../../components/Navbar/Navbar";
import Question from "../../components/Question/Question";
import SearchBox from "../../components/SearchBox/SearchBox";
import Sidebar from "../../components/Sidebar/Sidebar";
import QuestionList from "../../components/QuestionList/QuestionList";

const HomePage = () => {

    return (
        <div>
            <Navbar />
            <SearchBox />
            <div className="content">
                <QuestionList />
                <Sidebar tagList={["help", "funny", "Adam"]} />
            </div>
        </div>
    );
};

export default HomePage;
