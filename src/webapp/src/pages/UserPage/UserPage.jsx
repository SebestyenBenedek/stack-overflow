import React from 'react'
import Header from "./Header";

import QuestionItem from "../../components/QuestionItem/QuestionItem";
import Navbar from "../../components/Navbar/Navbar";

const UserPage = () => {

    return (
        <div className="UserPage">
            <Navbar />
            <Header />
            <hr />
            <br />
            {/*<hr />*/}
            {/*<h1 className="aboutheader">About Me</h1>*/}
            {/*<hr />*/}
            {/*<About />*/}
            {/*<br />*/}
            {/*<hr />*/}
            {/*<h1 className="skillheader">My Skills</h1>*/}
            {/*<hr />*/}
            {/*<Skills />*/}
            {/*<hr />*/}
            <h1 className="questionheader">My Questions</h1>
            <hr/>
            <QuestionItem />
            <hr/>
            <h1 className="answerheader">My Answers</h1>
            <hr/>
            {/*<AnswerList />*/}
            <hr/>
        </div>
    )
}

export default UserPage
