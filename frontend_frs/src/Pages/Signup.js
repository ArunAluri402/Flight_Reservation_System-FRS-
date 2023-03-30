import React from "react";
import { Link } from "react-router-dom";
import "../Styles/signup.css";

const Signup = () => {
  return (
    <div className="signup_container">
      <div className="logo_container">
        <img className="logo" alt="logo" src="./Assets/logo.png" />
      </div>
      <div className="form_container">
        <h2 className="heading">Sign up</h2>
        <form className="signup_form">
          <input className="ip" placeholder="First Name" />
          <input className="ip" placeholder="Last Name" />
          <input className="ip" placeholder="E-Mail" />
          <input className="ip" placeholder="Phone" />
          <input className="ip" placeholder="Password" />
          <button className="signup_button">Sign Up</button>
        </form>
        <h5>
          Already have an Account? <Link to="/">Login</Link> here
        </h5>
      </div>
    </div>
  );
};

export default Signup;
