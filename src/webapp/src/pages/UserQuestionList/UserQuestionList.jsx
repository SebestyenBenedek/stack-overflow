import {useEffect, useState} from "react";
import question from "../../components/Question/Question";
import Loading from "../../components/Loading/Loading";
import QuestionItem from "../../components/QuestionItem/QuestionItem";
import QuestionTable from "../../components/QuestionTable/QuestionTable";


function UserQuestionList() {
    const [loading, setLoading] = useState(true);
    const [questionList, setQuestionList] = useState([]);

    useEffect(() => {
        const fetchQuestion = async () => {
            const response = await fetch("/api/users/{id}/questions");
            const jsonData = await response.json();
            setQuestionList(jsonData.questions);
            setLoading(false);
        };
        fetchQuestion();
    }, []);

    const handleDelete = async (id) => {
        const response = await fetch(`/api/questions/${id}`, {
            method: "DELETE",
            headers: {
                token: localStorage.getItem("token"),
            },
        });
        setQuestionList(questionList.filter((question) => question.id !== id));
    };

    if (loading) return <Loading />;

    return <QuestionTable questionList={questionList} onDelete={handleDelete} />;
}

export default UserQuestionList;
