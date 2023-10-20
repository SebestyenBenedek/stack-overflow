import React, {useEffect, useState} from "react";
import "./HomePage.css"; // Import your CSS file for custom styles
import Navbar from "../../components/Navbar/Navbar";
import SearchBox from "../../components/SearchBox/SearchBox";
import Sidebar from "../../components/Sidebar/Sidebar";
import QuestionList from "../../components/QuestionList/QuestionList";
import Loading from "../../components/Loading/Loading";
import Question from "../../components/Question/Question";

const HomePage = () => {
    const [loading, setLoading] = useState(true);
    const [questions, setQuestions] = useState([]);

    useEffect(() => {
        fetch('/api/questions/')
            .then((res) => res.json())
            .then((data) => {
                //console.log(data);
                setQuestions(data);
                setLoading(false);
            });
    }, []);

    //console.log(questions);
    if (loading) return <Loading />

    return (
        <div>
            <Navbar />
            <SearchBox />
            <div className="page-content" >
                <h1 className="title is-2">Questions</h1>
                <hr className="hr-style"/>
                {questions?.map((question) => (
                    <Question key={question.id} question={question} />
                ))}
            </div>
        </div>
    );
};

export default HomePage;
