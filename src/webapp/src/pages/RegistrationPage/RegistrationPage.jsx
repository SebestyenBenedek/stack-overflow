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
    const handleSubmit = async (e) => {
        e.preventDefault();

        await fetch("/api/users/", {
            method: "POST",
            body:JSON.stringify(formInput),
            headers: { 'Content-Type': 'application/json', 'Accept': '*/*', 'Access-Control-Allow-Credentials': true}
        }).then(()=>{
            console.log("goood")
        }).catch(err => console.log(err))
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Username:</label>
                    <input name="username" onChange={onInputChange} type="text"/>
                </div>
                <div>
                    <label>Password:</label>
                    <input name="password" onChange={onInputChange} type="text"/>
                </div>
                <div>
                    <label>E-mail:</label>
                    <input name="email" onChange={onInputChange} type="text"/>
                </div>

                <button>Register</button>
            </form>
        </div>
    );
}

export default RegistrationPage;