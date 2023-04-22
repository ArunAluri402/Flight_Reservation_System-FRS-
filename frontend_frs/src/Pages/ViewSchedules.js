import React, { useEffect, useState } from "react";
import { ACCESS_TOKEN } from "../constants";
import { getallSchedules } from "../Services/Worker";
import Header from "../Components/Header";

function ViewSchedules() {
  const [schedules, setSchedules] = useState([]);

  useEffect(() => {
    if (ACCESS_TOKEN) {
      getallSchedules().then((res) => setSchedules(res));
    }
  }, []);
  return (
    <div className="Add_flight_form">
      <Header buttonName="Logout" buttonclassName="logout_button" />
      <div className="flightList_table">
        <h2 className="view_heading">Schedule table</h2>
        <table align="center" className="flightTable">
          <thead className="table_heading_main">
            <tr className="table_row">
              <th className="table_heading">Flight Name</th>
              <th className="table_heading">Source ---&gt; Destination</th>
              <th className="table_heading">Available Days</th>
              <th className="table_heading">Departure Time</th>
              <th className="table_heading">Duration</th>
              <th className="table_heading">Fare</th>
            </tr>
          </thead>
          <tbody className="table_body">
            {schedules.map((sc) => {
              return (
                <tr className="table_row" key={sc.scheduleID}>
                  <td className="table_data">{sc.flightBean.flightName}</td>
                  <td className="table_data">
                    <strong>
                      {sc.routeBean.source}---&gt; {sc.routeBean.destination}
                    </strong>
                  </td>
                  <td className="table_data">{sc.availableDays}</td>
                  <td className="table_data">{sc.departureTime}</td>
                  <td className="table_data">{sc.travelduration} hours</td>
                  <td className="table_data">{sc.routeBean.fare} Rs</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewSchedules;
