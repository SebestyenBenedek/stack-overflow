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

        </div>
    )

}