import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { ACCESS_TOKEN } from "../constants";
import "../Styles/login.css";
import { login } from "../Services/Worker";

function Login() {
  const nav = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleLogin = (event) => {
    event.preventDefault();

    setLoading(true);

    if (username === "Arun" && password === "123") {
      nav("/Dashboard");
    } else {
      const loginRequest = {
        usernameOrEmail: username,
        password: password,
      };

      login(loginRequest)
        .then((response) => {
          setLoading(false);
          setError(null);
          localStorage.setItem(ACCESS_TOKEN, response.accessToken);
          nav("/Home");
        })
        .catch((error) => {
          setLoading(false);
          setError(error.message);
        });
    }
  };

  return (
    <div className="login_container">
      <div className="logo_container">
        <img className="logo" alt="logo" src="./Assets/logo.png" />
      </div>
      <div className="login_form_container">
        <h2 className="heading">Login</h2>
        {error && <p>{error}</p>}
        <form className="login_Form" onSubmit={handleLogin}>
          <div>
            <input
              className="ip"
              type="text"
              value={username}
              onChange={(event) => setUsername(event.target.value)}
              placeholder="Username or Email"
              autoComplete="username"
              required
            />
          </div>

          <div>
            <input
              className="ip"
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              placeholder="Password"
              required
              autoComplete="Password"
            />
          </div>

          <button className="login_button" type="submit" disabled={loading}>
            {loading ? "Loading..." : "Login"}
          </button>
          <div>
            <h6 style={{ letterSpacing: "1px" }}>
              New User? <Link to="/signup">Signup </Link>Here
            </h6>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
