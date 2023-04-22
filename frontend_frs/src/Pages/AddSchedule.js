import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { ACCESS_TOKEN } from "../constants";
import Header from "../Components/Header";
import axios from "axios";
import { addschedule, getFlightList, getallroutes } from "../Services/Worker";
function AddSchedule() {
  const nav = useNavigate();

  const [selectFlight, SetSelectFlight] = useState("");
  const [selectRoute, setSelectRoute] = useState("");

  const [selectedFlight, setSelectedFlight] = useState([
    {
      flightID: "",
      flightName: "",
    },
  ]);

  const [selectedRoute, setSelectedRoute] = useState([
    {
      routeID: "",
      source: "",
    },
  ]);

  const [schedule, setSchedule] = useState({
    travelduration: 0,
    availableDays: "",
    departureTime: "",
    flightBean: {
      flightID: 0,
      flightName: "",
      seatingCapacity: 0,
      reservationCapacity: 0,
    },
    routeBean: {
      routeID: 0,
      source: "",
      destination: "",
      distance: 0,
      fare: 0,
    },
  });

  useEffect(() => {
    const fetchFlightList = async () => {
      const list = await getFlightList();
      setSelectedFlight(list);
    };
    const fetchRouteList = async () => {
      const list = await getallroutes();
      setSelectedRoute(list);
    };
    fetchFlightList();
    fetchRouteList();
  }, []);
  const handleInputChange = (event) => {
    const newData = { ...schedule };
    newData[event.target.id] = event.target.value;
    setSchedule(newData);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const data = await addschedule(schedule);
      console.log(data);
      alert("Schedule Added Sucessfully");
      nav("/viewschedules");
    } catch (error) {
      console.log(error);
    }
  };
  const handleChangeRoute = (e) => {
    const selectedRoutevalue = selectedRoute.find(
      (item) => item.source === e.target.value
    );

    const newData = { ...schedule };

    newData.routeBean.routeID = selectedRoutevalue.routeID;

    setSelectRoute(selectedRoutevalue.routeID);
    setSchedule({
      ...newData,
      routeBean: {
        ...newData.routeBean,
        routeID: selectedRoutevalue.routeID,
        source: selectedRoutevalue.source,
      },
    });
  };

  const handleChangeFlight = (e) => {
    const selectedFlightvalue = selectedFlight.find(
      (item) => item.flightName === e.target.value
    );

    const newData = { ...schedule };
    newData.flightBean.flightID = selectedFlightvalue.flightID;
    SetSelectFlight(selectedFlightvalue.flightID);
    setSchedule({
      ...newData,
      flightBean: {
        ...newData.flightBean,
        flightName: selectedFlightvalue.flightName,
      },
    });
  };

  console.log(selectFlight);
  console.log(selectRoute);
  console.log(schedule);
  return (
    <div className="Add_flight_form">
      <Header buttonName="Logout" buttonclassName="logout_button" />
      <h2 className="view_heading">Add Route</h2>
      <form className="Add_flightTable" onSubmit={handleSubmit}>
        <div className="flex">
          <div className="flex_addflight">
            <label className="side_label">Select Flight</label>
            <label className="side_label">Select Source</label>

            <label className="side_label">Travel Duration</label>
            <label className="side_label">Available Days</label>
            <label className="side_label">Departure Time</label>
          </div>
          <div className="flex_ip">
            <select
              id="flightName"
              name="flightName"
              defaultValue={selectedFlight}
              onChange={handleChangeFlight}
              required
            >
              <option value="">Select Flight Name</option>
              {selectedFlight.map((flight) => (
                <option key={flight.flightID} value={flight.flightName}>
                  {flight.flightName}
                </option>
              ))}
            </select>
            <select
              id="source"
              name="source"
              defaultValue={selectedRoute}
              onChange={handleChangeRoute}
            >
              <option value="">--Select Route--</option>
              {selectedRoute.map((route) => (
                <option key={route.routeID} value={route.source}>
                  {route.source}---&gt;{route.destination}
                </option>
              ))}
            </select>

            <input
              className="ip"
              type="number"
              value={schedule.travelduration}
              id="travelduration"
              onChange={handleInputChange}
            />
            <input
              className="ip"
              type="text"
              value={schedule.availableDays}
              id="availableDays"
              onChange={handleInputChange}
            />
            <input
              className="ip"
              type="text"
              value={schedule.departureTime}
              id="departureTime"
              onChange={handleInputChange}
            />
          </div>
        </div>

        <div className="buttonflex">
          <button className="logout_button" type="submit">
            Add Schedule
          </button>
        </div>
      </form>
    </div>
  );
}

export default AddSchedule;
