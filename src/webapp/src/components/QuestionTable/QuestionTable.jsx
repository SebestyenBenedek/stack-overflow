import {useNavigate} from "react-router-dom";
import question from "../Question/Question";


function QuestionTable({ questionList, onDelete }) {
    const navigate = useNavigate();

    return (
        <table>
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Tag</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {questionList.map((question) => (
                <tr key={question.id}>
                    <td>{question.title}</td>
                    <td>{question.description}</td>
                    <td>{question.tag}</td>
                    <td>
                        <button onClick={() => onDelete(question.id)}>Delete</button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default QuestionTable;