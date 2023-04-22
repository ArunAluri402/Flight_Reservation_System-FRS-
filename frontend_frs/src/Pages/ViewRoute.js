import React, { useEffect, useState } from "react";
import { getallroutes } from "../Services/Worker";
import { ACCESS_TOKEN } from "../constants";
import Header from "../Components/Header";

function ViewRoute() {
  const [routeData, setRouteData] = useState([]);

  useEffect(() => {
    if (ACCESS_TOKEN) {
      getallroutes().then((res) => setRouteData(res));
    }
  }, []);
  console.log(routeData);
  return (
    <div className="view_container">
      <Header buttonclassName="logout_button" buttonName="Logout" />
      <div className="flightList_table">
        <h2 className="view_heading">Route List</h2>
        <table align="center" className="flightTable">
          <thead className="table_heading_main">
            <tr className="table_row">
              <th className="table_heading">Source</th>
              <th className="table_heading">Destination</th>
              <th className="table_heading">Distance</th>
              <th className="table_heading">Fare(Rs)</th>
            </tr>
          </thead>
          <tbody className="table_body">
            {routeData.map((route) => (
              <tr className="table_row" key={route.routeID}>
                <td className="table_data">{route.source}</td>
                <td className="table_data">{route.destination}</td>
                <td className="table_data">{route.distance} KMS</td>
                <td className="table_data">{route.fare}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewRoute;
