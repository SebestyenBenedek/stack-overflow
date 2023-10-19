import {useEffect, useState} from "react";
import question from "../../components/Question/Question";
import Loading from "../../components/Loading/Loading";
import QuestionList from "../../components/QuestionList/QuestionList";
import AnswerTable from "../../components/AnswerTable";


function UserAnswerList() {
    const [loading, setLoading] = useState(true);
    const [answerList, setAnswerList] = useState([]);

    useEffect(() => {
        const fetchAnswer = async () => {
            const response = await fetch("/api/users/{id}/answers");
            const jsonData = await response.json();
            setAnswerList(jsonData.answers);
            setLoading(false);
        };
        fetchAnswer();
    }, []);

    const handleDelete = async (id) => {
        const response = await fetch(`/api/answers/${id}`, {
            method: "DELETE",
            headers: {
                token: localStorage.getItem("token"),
            },
        });
        setAnswerList(answerList.filter((answer) => answer.id !== id));
    };

    if (loading) return <Loading />;

    return <AnswerTable answerList={answerList} onDelete={handleDelete} />;
}

export default UserAnswerList;
