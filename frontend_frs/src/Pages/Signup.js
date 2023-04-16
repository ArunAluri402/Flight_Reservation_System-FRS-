import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { signup } from "../Services/Worker";
import "../Styles/signup.css";

function Signup() {
  const [username, setUsername] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [dateOfBirth, setDateOfBirth] = useState("");
  const [gender, setGender] = useState("");
  const [street, setStreet] = useState("");
  const [location, setLocation] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [pincode, setPincode] = useState(0);
  const [mobileNo, setMobileNo] = useState(0);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(false);

  const nav = useNavigate();
  const handleSignup = (event) => {
    event.preventDefault();

    setLoading(true);

    const signupRequest = {
      username: username,
      name: name,
      email: email,
      password: password,
      firstName: firstName,
      lastName: lastName,
      dateOfBirth: dateOfBirth,
      gender: gender,
      street: street,
      location: location,
      city: city,
      state: state,
      pincode: pincode,
      mobileNo: mobileNo,
    };

    signup(signupRequest)
      .then(() => {
        setLoading(false);
        setError(null);
        setSuccess(true);
      })
      .catch((error) => {
        setLoading(false);
        setError(error.message);
        setSuccess(false);
      });

    // setTimeout(() => {
    //   nav("/");
    // }, 1500);
  };

  return (
    <div className="signup_container">
      <div className="logo_container">
        <img className="logo" alt="logo" src="./Assets/logo.png" />
      </div>
      <div className="form_container">
        <div className="container2">
         
          <h2>Signup</h2>
          {error && <p>{error}</p>}
          {success && <p>Signup successful!</p>}
          <form className="signup_form" onSubmit={handleSignup}>
            <div className="flex">
              <input
                className="ip"
                type="text"
                value={firstName}
                onChange={(event) => setFirstName(event.target.value)}
                placeholder="First Name"
                required
              />
              <input
                className="ip"
                type="text"
                value={lastName}
                onChange={(event) => setLastName(event.target.value)}
                placeholder="Last Name"
                required
              />
            </div>

            <div className="flex">
              <input
                className="ip"
                type="text"
                value={name}
                onChange={(event) => setName(event.target.value)}
                placeholder="Full Name"
                required
              />
              <input
                className="ip"
                type="text"
                value={username}
                onChange={(event) => setUsername(event.target.value)}
                placeholder=" Username"
                required
              />
            </div>

            <div className="flex">
              <input
                className="ip"
                type="email"
                value={email}
                onChange={(event) => setEmail(event.target.value)}
                placeholder=" Email"
                required
              />

              <input
                className="ip"
                type="password"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
                placeholder="Password"
                required
              />
            </div>

            <div className="flex">
              <input
                className="ip"
                type="date"
                value={dateOfBirth}
                onChange={(event) => setDateOfBirth(event.target.value)}
                required
              />

              <select
                onChange={(event) => setGender(event.target.value)}
                value={gender}
              >
                <option>--Select the gender--</option>
                <option>Male</option>
                <option>Female</option>
              </select>
            </div>

            <div className="flex">
              <input
                className="ip"
                type="text"
                value={street}
                placeholder="Street"
                onChange={(event) => setStreet(event.target.value)}
                required
              />
              <input
                className="ip"
                type="text"
                value={location}
                onChange={(event) => setLocation(event.target.value)}
                placeholder="Location"
                required
              />
            </div>

            <div className="flex">
              <input
                className="ip"
                type="text"
                value={city}
                onChange={(event) => setCity(event.target.value)}
                placeholder="City"
                required
              />
              <input
                className="ip"
                type="text"
                value={state}
                onChange={(event) => setState(event.target.value)}
                placeholder="State"
                required
              />
            </div>

            <div className="flex">
              <input
                className="ip"
                type="number"
                value={pincode}
                onChange={(event) => setPincode(event.target.value)}
                placeholder="Pincode"
                required
              />
              <input
                className="ip"
                type="number"
                value={mobileNo}
                onChange={(event) => setMobileNo(event.target.value)}
                placeholder="Mobile"
                required
              />
            </div>

            <button className="signup_button" type="submit" disabled={loading}>
              {loading ? "Loading..." : "Signup"}
            </button>

            <div>
              <h6>
                Already have an account? <Link to="/">Login </Link>Here
              </h6>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Signup;
