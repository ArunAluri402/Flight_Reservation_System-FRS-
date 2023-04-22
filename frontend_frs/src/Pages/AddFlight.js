import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { ACCESS_TOKEN } from "../constants";
import "../Styles/AddFlight.css";
import Header from "../Components/Header";

function AddFlight() {
  const nav = useNavigate();
  const [flightData, setFlightData] = useState({
    flightID: 0,
    flightName: "",
    seatingCapacity: 0,
    reservationCapacity: 0,
  });

  const handlechange = (e) => {
    const newData = { ...flightData };
    newData[e.target.id] = e.target.value;
    setFlightData(newData);
  };

  const submithhandle = (e) => {
    e.preventDefault();
    if (localStorage.getItem(ACCESS_TOKEN)) {
      axios
        .post("http://localhost:8080/api/auth/AddFlight", flightData)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
      nav("/viewflight");
      alert("Flight added sucessfully");
    } else {
      alert("ERROR");
    }
  };

  return (
    <div className="Add_flight_form">
      <Header buttonclassName="logout_button" buttonName="Logout" />
      <h2 className="view_heading">Add Flight</h2>
      <form className="Add_flightTable" onSubmit={submithhandle}>
        <div className="flex">
          <div className="flex_addflight">
            <label className="side_label">Flight Name</label>
            <label className="side_label">Seating Capacity</label>
            <label className="side_label">Reservation Capacity</label>
          </div>
          <div className="flex_ip">
            <input
              className="ip"
              type="text"
              id="flightName"
              onChange={handlechange}
              value={flightData.flightName}
              autoFocus={true}
            />
            <input
              className="ip"
              type="number"
              value={flightData.seatingCapacity}
              id="seatingCapacity"
              onChange={handlechange}
            />
            <input
              className="ip"
              type="number"
              id="reservationCapacity"
              onChange={handlechange}
              value={flightData.reservationCapacity}
            />
          </div>
        </div>

        <div className="buttonflex">
          <button className="logout_button" type="submit">
            Add Flight
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddFlight;
