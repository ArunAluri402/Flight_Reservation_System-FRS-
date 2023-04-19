import React, { useEffect, useState } from "react";
import { getFlightList } from "../Services/Worker";
import "../Styles/ViewFlights.css";
import Header from "../Components/Header";
import { useNavigate } from "react-router-dom";

function ViewFlights() {
  const [flightList, setFlightList] = useState([]);

  useEffect(() => {
    getFlightList().then((res) => setFlightList(res));
  }, []);

  console.log(flightList);

  return (
    <div className="view_container">
      <Header
        buttonclassName="logout_button"
        buttonName="Logout"
        secondbuttonName="Add Flight"
        secondbuttonclassName="logout_button"
      />
      <div className="flightList_table">
        <h2 className="view_heading">Flights List</h2>
        <table align="center" className="flightTable">
          <thead className="table_heading_main">
            <tr className="table_row">
              <th className="table_heading">Flight Name</th>
              <th className="table_heading">Seating Capacity</th>
              <th className="table_heading">Reservation Capacity</th>
            </tr>
          </thead>
          <tbody className="table_body">
            {flightList.map((flight) => {
              return (
                <tr className="table_row" key={flight.flightID}>
                  <td className="table_data">{flight.flightName}</td>
                  <td className="table_data">{flight.seatingCapacity}</td>
                  <td className="table_data">{flight.reservationCapacity}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewFlights;
