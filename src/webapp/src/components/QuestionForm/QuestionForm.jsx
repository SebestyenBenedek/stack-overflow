import {useState} from "react";


function QuestionForm({ question, onCancel, onSave }) {
    const [title, setTitle] = useState(question?.title ?? '');
    const [description, setDescription] = useState(question?.description ?? '');

    const onSubmit = (e) => {
        e.preventDefault();

        onSave({
            title,
            description
        });
    };

    return (
        <form onSubmit={onSubmit} >
            <div className={"control"}>
                <label htmlFor={"title"}>Title:</label>
                <input value={title} onChange={(e) => setTitle(e.target.value)} name={"title"} id={"title"} />
            </div>

            <div className={"control"}>
                <label htmlFor={"description"}>Description:</label>
                <input value={description} onChange={(e) => setDescription(e.target.value)} name={"description"} id={"description"} />
            </div>

            <div className={"button"}>
                <button type="submit">Create question</button>
                <button onClick={onCancel}>Cancel</button>
            </div>
        </form>
    );
}

export default QuestionForm;