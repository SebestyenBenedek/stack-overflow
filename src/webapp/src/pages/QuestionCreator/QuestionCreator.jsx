import {useEffect, useState} from "react";
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
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(question),
        });
        setLoading(false);
    };

    if (loading) return <Loading />;

    return <QuestionForm onCancel={() => navigate('/')} onSave={handleCreate} />
}

export default QuestionCreator;