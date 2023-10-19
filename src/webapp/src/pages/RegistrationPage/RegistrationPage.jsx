import React, {useState} from "react";

const RegistrationPage = () => {
    const [formInput, setFormInput] = useState({
        username: "",
        password: "",
        email: ""
    });

    const onInputChange = (e) => {
        setFormInput((prev) => ({...prev, [e.target.name]: e.target.value}));
    };
    const handleSubmit = (e) => {
        e.preventDefault();
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Username:</label>
                    <input name="username" onSubmit={onInputChange} type="text"/>
                </div>
                <div>
                    <label>Password:</label>
                    <input name="password" onSubmit={onInputChange} type="text"/>
                </div>
                <div>
                    <label>E-mail:</label>
                    <input name="email" onSubmit={onInputChange} type="text"/>
                </div>

                <button>Register</button>
            </form>
        </div>
    );
}

export default RegistrationPage;