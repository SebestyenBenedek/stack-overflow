import React from "react";
import "./QuestionList.css";
import Question from "../Question/Question"; // Import your CSS file for custom styles

const QuestionList = () => {

    return (
        <div className="page-content">
            <h1 className="title is-2">Questions</h1>
            <hr className="hr-style"/>
            <Question title={"Where is my phone?"} user={"Bebe"}
                      description={"I lost my phone a few minutes ago and I can't find it :("}
                      tags={["phone", "omg", "help"]} answers={2} views={23} />
            <Question title={"Who was the funnier person Adam or Eve?"} user={"Lajos"}
                      description={"I had a typical shower thought this morning and I can't decide. HELP!!44!44!"}
                      tags={["Adam", "Eve", "shower thought", "funny"]} answers={7} views={76} />
        </div>
    );
};

export default QuestionList;
