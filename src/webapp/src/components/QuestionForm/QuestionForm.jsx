import {useState} from "react";
import {useNavigate} from "react-router-dom";

function QuestionForm({ question, onCancel, onSave }) {
    const navigate = useNavigate();
    const [title, setTitle] = useState(question?.title ?? '');
    const [description, setDescription] = useState(question?.description ?? '');

    const onSubmit = (e) => {
        e.preventDefault();
        if (!localStorage.getItem('token')) {
            alert("You have to log in first!")
            navigate("/")
        }
        let userId = localStorage.getItem('token');

        onSave({
            title,
            description,
            userId,
        });
    };

    return (
        <section className="section">
            <div className="container">
                <div className="columns is-centered">
                    <div className="column is-half">
                        <h2 className="title has-text-centered">Ask a new question!</h2>
                        <form onSubmit={onSubmit}>
                            <div className="field">
                                <label className="label">Title</label>
                                <div className="control">
                                    <input className="input"
                                        value={title}
                                        onChange={(e) => setTitle(e.target.value)}
                                        name={"title"}
                                        id={"title"}
                                        placeholder={"Title of the question"}
                                        required={true}
                                    />
                                </div>
                            </div>
                            <div className="field">
                            <label className="label">Description</label>
                                <div className="control">
                                    <textarea className="input"
                                        style={{ resize: 'vertical' }}
                                        value={description}
                                        onChange={(e) => setDescription(e.target.value)}
                                        name={"description"}
                                        id={"description"}
                                        placeholder={"Description of the question"}
                                        required={true}
                                    />
                                </div>
                            </div>
                            <div className="field">
                            <div className="control">
                                    <button type="submit" className="button is-primary is-fullwidth">Submit!</button>
                                </div>
                            </div>
                            <div className="field">
                                <div className="control">
                                    <button className="button is-fullwidth" onClick={onCancel}>Back</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default QuestionForm;