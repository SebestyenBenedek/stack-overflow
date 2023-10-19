import {useNavigate} from "react-router-dom";


function AnswerTable({ answerList, onDelete }) {
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
            {answerList.map((answer) => (
                <tr key={answer.id}>
                    <td>{answer.title}</td>
                    <td>{answer.description}</td>
                    <td>
                        <button onClick={() => onDelete(answer.id)}>Delete</button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default AnswerTable;
