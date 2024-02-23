import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";

const RegistrationPage = () => {
    const [formInput, setFormInput] = useState({
        username: "",
        password: "",
        email: ""
    });
    const navigate = useNavigate();

    const onInputChange = (e) => {
        setFormInput((prev) => ({...prev, [e.target.name]: e.target.value}));
    };
    const handleSubmit = async (e) => {
        e.preventDefault();

        await fetch("/api/users/", {
            method: "POST",
            body:JSON.stringify(formInput),
            headers: { 'Content-Type': 'application/json', 'Accept': '*/*', 'Access-Control-Allow-Credentials': true}
        }).then(()=>{
            navigate("/");
            console.log("Successful registration!");
        }).catch(err => console.log(err))
    };

    return (
        <>
            <div className="hero is-fullheight">
                <div className="hero-body is-justify-content-center is-align-items-center">
                    <div className="columns is-flex is-flex-direction-column box">
                        <form onSubmit={handleSubmit}>
                            <div className="column">
                                <label>Email</label>
                                <input className="input is-primary"
                                       name="email"
                                       type="email"
                                       placeholder="Email"
                                       onChange={onInputChange}
                                />
                            </div>
                            <div className="column">
                                <label>Username</label>
                                <input className="input is-primary"
                                       name="username"
                                       type="text"
                                       placeholder="Username"
                                       onChange={onInputChange}
                                />
                            </div>
                            <div className="column">
                                <label>Password</label>
                                <input className="input is-primary"
                                       name="password"
                                       type="password"
                                       placeholder="Password"
                                       onChange={onInputChange}
                                />
                            </div>
                            <div className="column">
                                <button className="button is-primary is-fullwidth" type="submit">Sign up</button>
                            </div>
                            <div className="has-text-centered">
                                <p className="is-size-7">
                                    Already have an account?
                                    <Link to="/login" className="has-text-primary"> Log in</Link>
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

export default RegistrationPage;