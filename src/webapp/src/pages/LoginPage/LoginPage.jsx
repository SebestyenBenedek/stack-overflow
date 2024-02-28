import React, {useState} from "react";
import {Link, useNavigate} from "react-router-dom";

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

            localStorage.setItem("token", response.id)

            navigate("/")
        }).catch(err => console.log(err))
    }

    return (
        <>
            <div className="hero is-fullheight">
                <div className="hero-body is-justify-content-center is-align-items-center">
                    <div className="columns is-flex is-flex-direction-column box">
                        <form onSubmit={handleSubmit}>
                            <div className="column">
                                <label>Username</label>
                                <input className="input is-primary"
                                       name="username"
                                       type="text"
                                       placeholder="Username"
                                       onChange={onInputChange}
                                       required={true}
                                />
                            </div>
                            <div className="column">
                                <label>Password</label>
                                <input className="input is-primary"
                                       name="password"
                                       type="password"
                                       placeholder="Password"
                                       onChange={onInputChange}
                                       required={true}
                                />
                            </div>
                            <div className="column">
                                <button className="button is-primary is-fullwidth" type="submit">Login</button>
                            </div>
                            <div className="has-text-centered">
                                <p className="is-size-7">
                                    Don't have an account?
                                    <Link to="/registration" className="has-text-primary"> Sign up</Link>
                                </p>
                            </div>
                            <br/>
                            <div className="has-text-centered">
                                <Link to="/" className="has-text-primary">Go Back</Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
}

export default LoginPage;