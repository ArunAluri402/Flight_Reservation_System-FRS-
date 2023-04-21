import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { ACCESS_TOKEN } from "../constants";
import Header from "../Components/Header";
import axios from "axios";

function AddFlightRoute() {
  const nav = useNavigate();

  const [data, setData] = useState({
    routeID: 0,
    source: "",
    destination: "",
    distance: 0,
    fare: 0,
  });
  const handlechange = (e) => {
    const newData = { ...data };
    newData[e.target.id] = e.target.value;
    setData(newData);
  };

  const submithhandle = (e) => {
    e.preventDefault();
    if (localStorage.getItem(ACCESS_TOKEN)) {
      axios
        .post("http://localhost:8080/api/auth/AddRoute", data)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
      nav("/viewflightroute");
      alert("Route Added Sucessfully");
    } else {
      alert("ERROR");
    }
  };

  return (
    <div className="Add_flight_form">
      <Header buttonName="Logout" buttonclassName="logout_button" />
      <h2 className="view_heading">Add Route</h2>
      <form className="Add_flightTable" onSubmit={submithhandle}>
        <div className="flex">
          <div className="flex_addflight">
            <label className="side_label">Source</label>
            <label className="side_label">Destination</label>
            <label className="side_label">Distance(kms)</label>
            <label className="side_label">Fare(Rs)</label>
          </div>
          <div className="flex_ip">
            <input
              className="ip"
              type="text"
              id="source"
              value={data.source}
              onChange={handlechange}
            />
            <input
              className="ip"
              type="text"
              value={data.destination}
              id="destination"
              onChange={handlechange}
            />
            <input
              className="ip"
              type="number"
              id="distance"
              onChange={handlechange}
              value={data.distance}
            />
            <input
              className="ip"
              type="number"
              id="fare"
              onChange={handlechange}
              value={data.fare}
            />
          </div>
        </div>

        <div className="buttonflex">
          <button className="logout_button" type="submit">
            Add Route
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddFlightRoute;
