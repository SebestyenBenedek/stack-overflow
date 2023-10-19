import {useState} from "react";

function AnswerForm({ answer, onCancel, onSave }) {
    const [description, setDescription] = useState(answer?.description ?? '');
    const [userId, setUserId] = useState(answer?.userId ?? '');

    const onSubmit = () => {
        if (answer) {
            onSave({
                ...answer,
                description,
            });
        }

        onSave({
            description,
            userId,
        });
    };

    return (
        <form onSubmit={onSubmit} className={"createForm"}>
            <div className={"control"}>
                <label htmlFor={"description"}>Description:</label>
                <input value={description} onChange={(e) => setDescription(e.target.value)} name={"description"} id={"description"} />
            </div>

            <div className={"control"}>
                <label htmlFor={"tag"}>Tag:</label>
                <input value={userId} name={"userId"} id={"userId"} />
            </div>

            <div className={"button"}>
                <button type={"submit"}>Create question</button>
                <button onClick={onCancel}>Cancel</button>
            </div>
        </form>
    )
}

export default AnswerForm;