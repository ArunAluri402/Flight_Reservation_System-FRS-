import React from "react";
import "../Styles/login.css";

const Login = () => {
  return (
    <div className="login_container">
      <div>
        <img alt="logo" />
        <h2>Login</h2>
      </div>
      <div className="form_container">
        <form className="login_form">
          <input className="ip" placeholder="Username or Email" />
          <input className="ip" placeholder="Password" />
          <button className="login_button">Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;
