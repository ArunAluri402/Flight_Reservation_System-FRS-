import React, { useEffect, useState } from "react";
import { WorkerAPI } from "../Services/Worker";

const Home = () => {
  const [reservationDetails, setReservationDetails] = useState();

  useEffect(() => {
    const res = WorkerAPI.getReservations();
    console.log(res);
  }, []);

  return <h1>Home</h1>;
};

export default Home;
