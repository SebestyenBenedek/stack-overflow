import React from "react";
import "./QuestionItem.css";
import Question from "../Question/Question"; // Import your CSS file for custom styles

const QuestionItem = (props) => {

    const question = props.question;

    return (
        <div className="page-content" key={question.id}>
            <h1 className="title is-2">Questions</h1>
            <hr className="hr-style"/>
            {/*<a href={`http://localhost:3000/questions/${question.id}`}>
                <h2 className="title is-2">{question.title}</h2>
            </a>
            <p className="hr-style">{question.description}</p>*/}
            {<Question title={question.title} user={question.userId}
                      description={question.description} answers={question.numberOfAnswers} views={question.numberOfViews}/>}
            {/*<Question title={"Who was the funnier person Adam or Eve?"} user={"Lajos"}
                      description={"I had a typical shower thought this morning and I can't decide. HELP!!44!44!"}
                      tags={["Adam", "Eve", "shower thought", "funny"]} answers={7} views={76} />*/}
        </div>
    );
};

export default QuestionItem;
