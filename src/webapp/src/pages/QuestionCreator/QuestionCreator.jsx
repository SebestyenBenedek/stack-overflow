import {useState} from "react";
import Loading from "../../components/Loading/Loading";
import {useNavigate} from "react-router-dom";
import QuestionForm from "../../components/QuestionForm/QuestionForm";

function QuestionCreator() {
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const handleCreate = async (question) => {
        setLoading(true);
        await fetch('/api/questions/', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
                token: localStorage.getItem('token'),
            },
            body: JSON.stringify(question),
        });
        setLoading(false);
        navigate('/api/questions/all');
    };

    if (loading) return <Loading />;

    return <QuestionForm onCancel={() => navigate('/api/questions/all')} onSave={handleCreate()} />
}

export default QuestionCreator;