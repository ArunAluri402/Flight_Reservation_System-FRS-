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
    // flight
    if (username === "AD001" && password === "AD001") {
      nav("/addflight");
    } else if (username === "AD002" && password === "AD002") {
      nav("/deleteflight");
    } else if (username === "AD003" && password === "AD003") {
      nav("/viewflight");
    } else if (username === "AD004" && password === "AD004") {
      nav("/modifyflight");
    }
    // route
    else if (username === "AD005" && password === "AD005") {
      nav("/addflightroute");
    } else if (username === "AD006" && password === "AD006") {
      nav("/delflightroute");
    } else if (username === "AD007" && password === "AD007") {
      nav("/viewflightroute");
    } else if (username === "AD008" && password === "AD008") {
      nav("/viewflightroute");
    }
    // schedule
    else if (username === "AD009" && password === "AD009") {
      nav("/addschedule");
    } else if (username === "AD010" && password === "AD010") {
      nav("/deleteschedule");
    } else if (username === "AD011" && password === "AD011") {
      nav("/viewschedules");
    } else if (username === "AD011" && password === "AD011") {
      nav("/viewschedules");
    }
    // resevation
    else if (username === "AD011" && password === "AD011") {
      nav("/viewreservation");
    }

    //user
    else if (username === "US001" && password === "US001") {
      nav("/signup");
    } else if (username === "US002" && password === "US002") {
      nav("/viewschedules");
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
          alert("Wrong Credentials");
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
              autoFocus={true}
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
        </form>
      </div>
    </div>
  );
}

export default Login;
