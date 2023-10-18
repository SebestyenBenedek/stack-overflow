import React, {useState} from "react";

const LoginPage = () =>{
    const [formInput, setFormInput] = useState({
        username: "",
        password: "",
    });

    const onInputChange = (e) => {
        setFormInput((prev) => ({ ...prev, [e.target.name]: e.target.value }));
    };

    const handleSubmit = (e) =>{
        e.preventDefault();

    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Username:</label>
                    <input name="username" onChange={onInputChange} type="text"/>
                </div>
                <div>
                    <label>Password:</label>
                    <input name="password" onChange={onInputChange} type="password"/>
                </div>

                <button>Login</button>
            </form>
        </div>
    );
}

export default LoginPage;