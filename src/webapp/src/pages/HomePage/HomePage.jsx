import React, {useEffect, useState} from "react";
import "./HomePage.css"; // Import your CSS file for custom styles
import Navbar from "../../components/Navbar/Navbar";
import SearchBox from "../../components/SearchBox/SearchBox";
import Sidebar from "../../components/Sidebar/Sidebar";
import QuestionItem from "../../components/QuestionItem/QuestionItem";
import Loading from "../../components/Loading/Loading";

const HomePage = () => {
    const [loading, setLoading] = useState(true);
    const [questions, setQuestions] = useState([]);

    useEffect(() => {
        fetch('/api/questions/')
            .then((res) => res.json())
            .then((data) => {
                console.log(questions);
                setQuestions(data.questions);
                setLoading(false);
            });
    }, [questions]);

    //console.log(questions);
    if (loading) return <Loading />

    return (
        <div>
            <Navbar />
            <SearchBox />
            <div className="content">
                {questions?.map((question) => (
                    <QuestionItem key={question.id} question={question} />
                ))}
                <Sidebar tagList={["help", "funny", "Adam"]} />
            </div>
        </div>
    );
};

export default HomePage;
