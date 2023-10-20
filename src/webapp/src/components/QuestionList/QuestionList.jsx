import React from "react";
import "./QuestionList.css";
import Question from "../Question/Question"; // Import your CSS file for custom styles

const QuestionList = ({questions}) => {

    return (
        <div className="page-content" >
            <h1 className="title is-2">Questions</h1>
            <hr className="hr-style"/>
                {questions && questions?.map((question) => (
                    <Question key={question.id} questions={question} />
                ))}
        </div>
    );
};

export default QuestionList;
