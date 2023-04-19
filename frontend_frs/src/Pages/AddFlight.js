import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { addFlight } from "../Services/Worker";

function AddFlight() {
  const { flightID } = useParams();
  const nav = useNavigate();

  const [flightData, setFlightData] = useState({
    flightID: 0,
    flightName: "",
    seatingCapacity: "",
    reservationCapacity: "",
  });

  const handlechange = (e) => {
    const newData = { ...flightData };
    newData[e.target.id] = e.target.value;
    setFlightData(newData);
  };

  const submithhandle = (e) => {
    e.prventDefault();
    addFlight(flightData).then((res) => alert("Flight Added Sucessfully", res));

    nav("/viewflight");
    console.log(flightData);
  };

  return (
    <div className="Add_flight_form">
      <h2>Add Flight</h2>
      <form onSubmit={submithhandle}>
        <label>
          Flight Name
          <input
            type="text"
            id="flightName"
            onChange={handlechange}
            value={flightData.flightName}
          />
        </label>
        <label>
          Seating Capacity
          <input
            type="number"
            value={flightData.seatingCapacity}
            id="seatingCapacity"
            onChange={handlechange}
          />
        </label>
        <label>
          Reservation Capacity
          <input
            type="number"
            id="reservationCapacity"
            onChange={handlechange}
            value={flightData.reservationCapacity}
          />
        </label>
        <div className="buttonflex">
          <button className="Add_btn" type="submit">
            {flightID ? "Update Flight" : "Add Flight"}
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddFlight;
