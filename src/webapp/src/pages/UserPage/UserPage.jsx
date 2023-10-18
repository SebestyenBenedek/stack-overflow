import React from 'react'
import Header from "./Header";
import About from "./About";
import Navbar from "./Navbar";

import './UserPage.css'
import Skills from "./Skills";
import QuestionList from "../../components/QuestionList/QuestionList";

const UserPage = () => {

    return (
        <div className="UserPage">
            <Header />
            <hr />
            <Navbar />
            <br />
            <hr />
            <h1 className="aboutheader">About Me</h1>
            <hr />
            <About />
            <br />
            <hr />
            <h1 className="skillheader">My Skills</h1>
            <hr />
            <Skills />
            <hr />
            <h1 className="questionheader">My Questions</h1>
            <hr/>
            <QuestionList />
            <hr/>
        </div>
    )
}

export default UserPage
