import React, {useState} from "react";
import {useNavigate} from "react-router-dom";

const LoginPage = () =>{
    const [formInput, setFormInput] = useState({
        username: "",
        password: "",
    });
    const navigate = useNavigate();

    const onInputChange = (e) => {
        setFormInput((prev) => ({ ...prev, [e.target.name]: e.target.value }));
    };

    const handleSubmit = async (e) =>{
        e.preventDefault();
        await fetch("/api/auth/login", {
            method: "POST",
            body:JSON.stringify(formInput),
            headers: { 'Content-Type': 'application/json', 'Accept': '*/*', 'Access-Control-Allow-Credentials': true}
        }).then(async (res) =>{
            const response = await res.json()

            localStorage.setItem("id", response.id)

            navigate("/")
        }).catch(err => console.log(err))
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