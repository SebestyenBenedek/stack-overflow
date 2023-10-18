import {useState} from "react";


function QuestionForm({ question, onCancel, onSave }) {
    const [title, setTitle] = useState(question?.title ?? '');
    const [description, setDescription] = useState(question?.description ?? '');
    const [tag, setTag] = useState(question?.tag ?? '');

    const onSubmit = () => {
        onSave({
            title,
            description,
            tag,
        });
    };

    return (
        <form onSubmit={onSubmit} className={"createForm"}>
            <div className={"control"}>
                <label htmlFor={"title"}>Title:</label>
                <input value={title} onChange={(e) => setTitle(e.target.value)} name={"title"} id={"title"} />
            </div>

            <div className={"control"}>
                <label htmlFor={"description"}>Description:</label>
                <input value={description} onChange={(e) => setDescription(e.target.value)} name={"description"} id={"description"} />
            </div>

            <div className={"control"}>
                <label htmlFor={"tag"}>Tag:</label>
                <input value={tag} onChange={(e) => setTag(e.target.value)} name={"tag"} id={"tag"} />
            </div>

            <div className={"button"}>
                <button type={"submit"}>Create question</button>
                <button onClick={onCancel}>Cancel</button>
            </div>
        </form>
    );
}

export default QuestionForm;