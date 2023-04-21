import React, { useEffect, useState } from "react";
import { ACCESS_TOKEN } from "../constants";
import { deleteFlightRoutes, getallroutes } from "../Services/Worker";
import Header from "../Components/Header";
import { useParams } from "react-router-dom";

function DeleteFlightRoute() {
  const { id } = useParams();
  const [routeData, setRouteData] = useState([]);

  useEffect(() => {
    getallroutes().then((res) => setRouteData(res));
  }, [id]);

  const deleteHandle = (id) => {
    deleteFlightRoutes(id).then(() => {
      setRouteData(routeData.filter((item) => item.routeID !== id));
    });
  };
  return (
    <div className="view_container">
      <Header
        buttonclassName="logout_button"
        buttonName="Logout"
        secondbuttonName="Add Route"
        secondbuttonclassName="logout_button"
      />
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
              <tr key={route.routeID}>
                <td>{route.source}</td>
                <td>{route.destination}</td>
                <td>{route.distance} KMS</td>
                <td>{route.fare}</td>

                <td className="table-data">
                  <button
                    className="delete_button"
                    onClick={() => deleteHandle(route.routeID)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default DeleteFlightRoute;
