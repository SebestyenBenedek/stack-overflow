import {useState} from "react";
import {useNavigate} from "react-router-dom";
import Loading from "../../components/Loading/Loading";
import AnswerForm from "../../components/AnswerForm/AnswerForm";


function AnswerCreator() {
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const handleCreate = async (answer, questionId) => {
        setLoading(true);
        await fetch(`/api/questions/${questionId}/answers/`, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
                token: localStorage.getItem('token'),
            },
            body: JSON.stringify(answer),
        });
        setLoading(false);
        navigate(`/api/questions/${questionId}`);
    };

    if (loading) return <Loading />;

    return <AnswerForm onCancel={() => navigate('/api/questions/')} onSave={handleCreate()} />
}

export default AnswerCreator;