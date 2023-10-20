import React from "react";
import "./Question.css";
import questionItem from "../QuestionList/QuestionList"; // Import your CSS file for custom styles

const Question = ({question}) => {

    return (
        <div className="box question-box">
            <article className="media">
                <div className="media-content">
                    <div className="content">
                        <p>
                            <span className="icon-text">
                              <span className="icon">
                                <i className="fa-regular fa-circle-question"></i>
                              </span>
                              <span><strong>{ question.title }</strong></span>
                            </span> <small>@{question.userId}</small>
                            <br />
                            {question.description}
                        </p>
                    </div>
                    <hr className="hr-style"/>
                    <nav className="level is-mobile">
                        <div className="level-left">

                            {/*{tags?.map((tag) => {
                                return (
                                    <span className="level-item">
                                        <span className="tag is-rounded">
                                            <span className="icon">
                                                <i className="fa-solid fa-hashtag"></i>
                                            </span>
                                            <strong>{tag}</strong>
                                        </span>
                                    </span>
                                )
                            })}*/}

                        </div>

                        <div className="level-right">

                            <span className="level-item">
                                <span className="is-medium is-white"><strong>{question.numberOfAnswer}</strong> answers</span>
                            </span>

                            <span className="level-item">
                                <span className="is-medium is-white"><strong>{question.numberOfViews}</strong> views</span>
                            </span>

                        </div>
                    </nav>
                </div>
            </article>
        </div>
    );
};

export default Question;
