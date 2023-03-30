import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "../Styles/login.css";

const Login = () => {
  const Navigate = useNavigate();
  const [details, setDetails] = useState({
    usernameorEmail: "",
    password: "",
  });

  const handleChange = (event) => {
    const newDetails = { ...details };
    newDetails[event.target.id] = event.target.value;
    setDetails(newDetails);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (details.usernameorEmail === "Arun" && details.password === "1234") {
      Navigate("/Home");
      alert("Login Sucessful");
    } else {
      alert("Enter valid Credentials");
      window.location.reload();
    }
  };

  return (
    <div className="login_container">
      <div className="logo_container">
        <img className="logo" alt="logo" src="./Assets/logo.png" />
      </div>
      <div className="login_form_container">
        <h2 className="heading">Login</h2>
        <form className="login_form">
          <input
            id="usernameorEmail"
            className="ip"
            placeholder="Username or Email"
            type="text"
            onChange={handleChange}
            autoFocus
          />
          <input
            id="password"
            className="ip"
            placeholder="Password"
            type="password"
            onChange={handleChange}
          />
          <button className="login_button" type="submit" onClick={handleSubmit}>
            Login
          </button>
        </form>
        <h5>
          Dont have an Account? <Link to="/signup">Signup</Link> here
        </h5>
      </div>
    </div>
  );
};

export default Login;
