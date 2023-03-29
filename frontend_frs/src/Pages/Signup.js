import React from "react";
import "../Styles/signup.css";

const Signup = () => {
  return (
    <div className="signup_container">
      <div>
        <img alt="logo" />
        <h2>Sign up</h2>
      </div>
      <div className="form_container">
        <form className="signup_form">
          <input className="ip" placeholder="First Name" />
          <input className="ip" placeholder="Last Name" />
          <input className="ip" placeholder="E-Mail" />
          <input className="ip" placeholder="Phone" />
          <input className="ip" placeholder="Password" />
          <button className="signup_button">Sign Up</button>
        </form>
      </div>
    </div>
  );
};

export default Signup;
